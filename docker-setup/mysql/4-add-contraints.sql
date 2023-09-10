ALTER TABLE TB_BOOKING
ADD CONSTRAINT FK_RESOURCE_CODE FOREIGN KEY(RESOURCE_CODE) REFERENCES TB_RESOURCE(RESOURCE_CODE);

ALTER TABLE TB_BOOKING
ADD CONSTRAINT UN_BOOKING_DATE UNIQUE(BEGIN_HR, END_HR);

ALTER TABLE TB_BOOKING
ADD CONSTRAINT FK_USER_CODE FOREIGN KEY(USER_CODE) REFERENCES TB_USER(USER_CODE);

ALTER TABLE TB_BOOKING
ADD CONSTRAINT CK_STATUS_CODE CHECK(STATUS_CODE IN (1, 2, 3)) -- 1 = ATIVO, 2 = CONCLUIDO, 3 = CANCELADO
