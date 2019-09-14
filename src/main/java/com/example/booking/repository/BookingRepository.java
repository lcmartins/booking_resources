package com.example.booking.repository;

import com.example.booking.entities.Booking;
import com.example.booking.entities.Resource;
import com.example.booking.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository implements BookingOperations {


    public static final String RESOURCE_ID = "resourceId";
    public static final String USER_ID = "userId";
    public static final String BEGIN = "begin";
    public static final String END = "end";
    @Autowired
    private EntityManager entityManager;

    //@Value("${booking.default_database_schema}")
    private String schema = "dbo";

    public  List<Resource> listResources() {
        List<Object[]> resultList = getProcedureRows("PR_RESOURCE_LIST");
        List<Resource> resultListParsed = new ArrayList<>();
        for (Object[] e: resultList) {
            Resource resource = new Resource(Integer.parseInt(e[0].toString()),  e[1].toString());
            resultListParsed.add(resource);
        }
        return resultListParsed;
    }

    private List<Object[]> getProcedureRows(String procedure) {
        final StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(procedure);
        query.execute();
        return (List<Object[]>) query.getResultList();
    }

    public  List<User> listUsers() {
        List<Object[]> resultList = getProcedureRows("PR_USER_LIST");
        List<User> resultListParsed = new ArrayList<>();


        for (Object[] e: resultList) {
            User user = new User(Integer.parseInt(e[0].toString()),  e[1].toString());
            resultListParsed.add(user);
        }
        return resultListParsed;
    }

    public List<Booking> listBookings(LocalDate bookingDate) {
        final StoredProcedureQuery query = this.entityManager
                .createStoredProcedureQuery(schema + "." + "PR_BOOKING_LIST_BY_DATE")
                .registerStoredProcedureParameter("dataAgendamento", LocalDate.class, ParameterMode.IN)
                .setParameter("dataAgendamento", bookingDate);

        query.execute();
        List<Object[]> resultList = (List<Object[]>) query.getResultList();
        List<Booking> resultListParsed = new ArrayList<>();

        for (Object[] e: resultList) {
            Integer bookingId = Integer.parseInt(e[0].toString());
            Resource resource = new Resource(Integer.parseInt(e[1].toString()),  e[2].toString());
            User user = new User(Integer.parseInt(e[3].toString()),  e[4].toString());
            LocalDateTime begin = Timestamp.valueOf(e[5].toString()).toLocalDateTime();
            LocalDateTime end = Timestamp.valueOf(e[6].toString()).toLocalDateTime();
            Booking booking = new Booking(bookingId, resource, user, begin, end);
            resultListParsed.add(booking);
        }

        return resultListParsed;
    }

    public Integer createAndReturnId(Booking booking) {
        final StoredProcedureQuery query = this.entityManager
                .createStoredProcedureQuery(schema + "." + "PR_BOOKING_INSERT")
                .registerStoredProcedureParameter(RESOURCE_ID, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(USER_ID, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(BEGIN, LocalDateTime.class, ParameterMode.IN)
                .registerStoredProcedureParameter(END, LocalDateTime.class, ParameterMode.IN)
                .setParameter(RESOURCE_ID, booking.getRecurso().getId())
                .setParameter(USER_ID, booking.getUser().getId())
                .setParameter(BEGIN, booking.getBegin())
                .setParameter(END, booking.getEnd());

        query.execute();

        return (Integer) query.getSingleResult();
    }
}
