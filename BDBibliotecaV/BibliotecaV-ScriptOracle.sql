
--------------------------------------------------------
--  File created - Friday-November-23-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ANAQUEL
--------------------------------------------------------

  CREATE TABLE "ANAQUEL" 
   (	"CODANQ" NUMBER(*,0), 
	"NOMANQ" VARCHAR2(5 BYTE), 
	"COLANQ" VARCHAR2(5 BYTE), 
	"FILANQ" VARCHAR2(5 BYTE), 
	"ESTANQ" CHAR(1 BYTE) DEFAULT 'A'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "ANAQUEL"."CODANQ" IS 'Código del Anaquel.';
   COMMENT ON COLUMN "ANAQUEL"."NOMANQ" IS 'Nombre del Anaquel.(Primeros 2 caracteres son letras, el resto son números)';
   COMMENT ON COLUMN "ANAQUEL"."COLANQ" IS 'Columnas del Anaquel.';
   COMMENT ON COLUMN "ANAQUEL"."FILANQ" IS 'Filas del Anaquel.';
   COMMENT ON COLUMN "ANAQUEL"."ESTANQ" IS 'Estado del Anaquel.(A<activo>  I<inactivo>)';
--------------------------------------------------------
--  DDL for Table EDITORIAL
--------------------------------------------------------

  CREATE TABLE "EDITORIAL" 
   (	"CODEDIT" NUMBER(*,0), 
	"NOMEDIT" VARCHAR2(50 BYTE), 
	"ESTEDIT" CHAR(1 BYTE) DEFAULT 'A'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "EDITORIAL"."CODEDIT" IS 'Código del Editorial.';
   COMMENT ON COLUMN "EDITORIAL"."NOMEDIT" IS 'Nombre del Editorial.';
   COMMENT ON COLUMN "EDITORIAL"."ESTEDIT" IS 'Estado del Editorial.(A<activo>  I<inactivo>)';
--------------------------------------------------------
--  DDL for Table GENERO
--------------------------------------------------------

  CREATE TABLE "GENERO" 
   (	"CODGEN" NUMBER(*,0), 
	"NOMGEN" VARCHAR2(50 BYTE), 
	"ESTGEN" CHAR(1 BYTE) DEFAULT 'A'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "GENERO"."CODGEN" IS 'Código del Género.';
   COMMENT ON COLUMN "GENERO"."NOMGEN" IS 'Nombre del Género.';
   COMMENT ON COLUMN "GENERO"."ESTGEN" IS 'Estado del Género.(A<activo>  I<inactivo>)';
--------------------------------------------------------
--  DDL for Table LIBRO
--------------------------------------------------------

  CREATE TABLE "LIBRO" 
   (	"CODLIB" NUMBER(*,0), 
	"ISBNLIB" VARCHAR2(13 BYTE), 
	"TITLIB" VARCHAR2(50 BYTE), 
	"FECPUBLIB" DATE, 
	"CODAUT" NUMBER(*,0), 
	"CODGEN" NUMBER(*,0), 
	"CODEDIT" NUMBER(*,0), 
	"PAGLIB" VARCHAR2(4 BYTE), 
	"DESCLIB" VARCHAR2(300 BYTE), 
	"TAMLIB" VARCHAR2(5 BYTE), 
	"CODTIPOLIB" NUMBER(*,0), 
	"CODANQ" NUMBER(*,0), 
	"ESTLIB" CHAR(1 BYTE) DEFAULT 'A'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "LIBRO"."CODLIB" IS 'Código del Libro.';
   COMMENT ON COLUMN "LIBRO"."ISBNLIB" IS 'Número de Libro Estándar Internacional.';
   COMMENT ON COLUMN "LIBRO"."TITLIB" IS 'Título del Libro.';
   COMMENT ON COLUMN "LIBRO"."FECPUBLIB" IS 'Fecha de Publicación del Libro.';
   COMMENT ON COLUMN "LIBRO"."CODAUT" IS 'Código del Autor.';
   COMMENT ON COLUMN "LIBRO"."CODGEN" IS 'Código del Género.';
   COMMENT ON COLUMN "LIBRO"."CODEDIT" IS 'Código del Editorial.';
   COMMENT ON COLUMN "LIBRO"."PAGLIB" IS 'Número de páginas del Libro.';
   COMMENT ON COLUMN "LIBRO"."DESCLIB" IS 'Descripción del Libro.';
   COMMENT ON COLUMN "LIBRO"."TAMLIB" IS 'Descripción Física del Libro.(Tamaño)';
   COMMENT ON COLUMN "LIBRO"."CODTIPOLIB" IS 'Código del Tipo de Libro.';
   COMMENT ON COLUMN "LIBRO"."CODANQ" IS 'Código del Anaquel.';
   COMMENT ON COLUMN "LIBRO"."ESTLIB" IS 'Estado del Libro.(A<activo> I<inactivo>)';
--------------------------------------------------------
--  DDL for Table PERSONA
--------------------------------------------------------

  CREATE TABLE "PERSONA" 
   (	"CODPER" NUMBER(*,0), 
	"NOMPER" VARCHAR2(50 BYTE), 
	"APEPER" VARCHAR2(50 BYTE), 
	"DNIPER" VARCHAR2(8 BYTE), 
	"DIRPER" VARCHAR2(50 BYTE), 
	"TELFPER" VARCHAR2(9 BYTE), 
    "EMAPER" VARCHAR2(50 BYTE), 
	"PASPER" VARCHAR2(20 BYTE), 
	"TIPPER" CHAR(2 BYTE), 
	"ESTPER" CHAR(1 BYTE) DEFAULT 'A'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "PERSONA"."CODPER" IS 'Código de la Persona.';
   COMMENT ON COLUMN "PERSONA"."NOMPER" IS 'Nombre de la Persona.';
   COMMENT ON COLUMN "PERSONA"."APEPER" IS 'Apellido de la Persona.';
   COMMENT ON COLUMN "PERSONA"."DNIPER" IS 'DNI de la Persona.';
   COMMENT ON COLUMN "PERSONA"."DIRPER" IS 'Dirección de la Persona.';
   COMMENT ON COLUMN "PERSONA"."TELFPER" IS 'Número de Teléfono de la Persona.';
   COMMENT ON COLUMN "PERSONA"."EMAPER" IS 'Correo Electrónico de la Persona.';
   COMMENT ON COLUMN "PERSONA"."PASPER" IS 'Contraseña de la Persona.';
   COMMENT ON COLUMN "PERSONA"."TIPPER" IS 'Tipo de Persona.(AD<administrador>  BI<bibliotecario>  PR<profesor>  ES<estudiante> AT<autor>)';
   COMMENT ON COLUMN "PERSONA"."ESTPER" IS 'Estado de la Persona.(A<activo>  I<inactivo>)';
--------------------------------------------------------
--  DDL for Table PRESTAMO
--------------------------------------------------------

  CREATE TABLE "PRESTAMO" 
   (	"CODPRE" NUMBER(*,0), 
	"FECSALPRE" DATE, 
	"FECDEVPRE" DATE, 
    "ESTPRE" CHAR(1 BYTE) DEFAULT 'A', 
	"CODPER" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "PRESTAMO"."CODPRE" IS 'Código del Préstamo.';
   COMMENT ON COLUMN "PRESTAMO"."FECSALPRE" IS 'Fecha de Salida del Préstamo.';
   COMMENT ON COLUMN "PRESTAMO"."FECDEVPRE" IS 'Fecha de Devolución del Préstamo.';
   COMMENT ON COLUMN "PRESTAMO"."ESTPRE" IS 'Estado del Préstamo.(A<activo>  I<inactivo>)';
   COMMENT ON COLUMN "PRESTAMO"."CODPER" IS 'Código de la Persona.';
--------------------------------------------------------
--  DDL for Table PRESTAMO_DETALLE
--------------------------------------------------------

  CREATE TABLE "PRESTAMO_DETALLE" 
   (	"CODPREDET" NUMBER(*,0), 
	"CODPRE" NUMBER(*,0), 
	"CODLIB" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "PRESTAMO_DETALLE"."CODPREDET" IS 'Código del Detalle del Préstamo.';
   COMMENT ON COLUMN "PRESTAMO_DETALLE"."CODPRE" IS 'Código del Préstamo.';
   COMMENT ON COLUMN "PRESTAMO_DETALLE"."CODLIB" IS 'Código del Libro.';
--------------------------------------------------------
--  DDL for Table TIPO_LIBRO
--------------------------------------------------------

  CREATE TABLE "TIPO_LIBRO" 
   (	"CODTIPOLIB" NUMBER(*,0), 
	"NOMTIPOLIB" VARCHAR2(30 BYTE), 
	"ESTTIPOLIB" CHAR(1 BYTE) DEFAULT 'A'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "TIPO_LIBRO"."CODTIPOLIB" IS 'Código del Tipo de Libro.';
   COMMENT ON COLUMN "TIPO_LIBRO"."NOMTIPOLIB" IS 'Nombre del Tipo de Libro.';
   COMMENT ON COLUMN "TIPO_LIBRO"."ESTTIPOLIB" IS 'Estado del Tipo de Libro.(A<activo>  I<inactivo>)';
--------------------------------------------------------
--  DDL for View VW_AUTOR
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VW_AUTOR" ("CODPER", "NOMPER", "APEPER", "TIPPER", "ESTPER") AS 
  SELECT CODPER,NOMPER,APEPER,TIPPER,ESTPER 
  FROM PERSONA 
  WHERE TIPPER LIKE 'AT' AND ESTPER LIKE 'A'
;
--------------------------------------------------------
--  DDL for View VW_LECTOR
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VW_LECTOR" ("CODPER", "NOMPER", "APEPER", "DNIPER", "DIRPER", "TELFPER", "EMAPER", "PASPER", "TIPPER", "ESTPER") AS 
  SELECT CODPER,NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,case TIPPER when 'PR' then 'Profesor' when 'ES' then 'Estudiante' end as TIPPER,ESTPER 
  FROM PERSONA 
  WHERE TIPPER NOT LIKE 'AT' AND TIPPER NOT LIKE 'AD' AND TIPPER NOT LIKE 'BI' 
  AND ESTPER LIKE 'A'
;
--------------------------------------------------------
--  DDL for View VW_LIBRO
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VW_LIBRO" ("CODLIB", "ISBNLIB", "TITLIB", "FECPUBLIB", "CODAUT", "AUTOR", "CODGEN", "GENERO", "CODEDIT", "EDITORIAL", "PAGLIB", "DESCLIB", "TAMLIB", "CODTIPOLIB", "TIPO_LIBRO", "CODANQ", "ANAQUEL", "ESTLIB") AS 
  select CODLIB,ISBNLIB,TITLIB,TO_CHAR(FECPUBLIB, 'YYYY') as FECPUBLIB,Persona.CODPER as CODAUT,Concat(Persona.NOMPER,concat(' ',Persona.APEPER)) as Autor,Genero.CODGEN as CODGEN,Genero.NOMGEN as Genero,Editorial.CODEDIT as CODEDIT,
       Editorial.NOMEDIT as Editorial,PAGLIB,DESCLIB,TAMLIB,Tipo_Libro.CODTIPOLIB as CODTIPOLIB,Tipo_Libro.NOMTIPOLIB as Tipo_Libro,Anaquel.CODANQ as CODANQ,Concat(Anaquel.NOMANQ,concat(', Columna: ',Concat(Anaquel.COLANQ,Concat(', Fila: ',Anaquel.FILANQ)))) as Anaquel,
       case ESTLIB when 'A' then 'Disponible' when 'I' then 'No Disponible' end as ESTLIB
from Libro
inner join Persona
on Persona.CODPER  = Libro.CODAUT
inner join Editorial
on Editorial.CODEDIT  = Libro.CODEDIT
inner join Genero
on Genero.CODGEN = Libro.CODGEN
inner join Tipo_Libro
on Tipo_Libro.CODTIPOLIB = Libro.CODTIPOLIB
inner join Anaquel
on Anaquel.CODANQ = Libro.CODANQ
;
--------------------------------------------------------
--  DDL for View VW_LIBROBUSQUEDA
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VW_LIBROBUSQUEDA" ("CODLIB", "TITLIB", "FECPUBLIB", "PAGLIB", "DESCLIB", "TAMLIB", "ESTLIB", "NOMAUT", "APEAUT", "ESTAUT", "NOMGEN", "ESTGEN", "NOMEDIT", "ESTEDIT", "NOMANQ", "ESTANQ") AS 
  SELECT 
        LIBRO.CODLIB CODLIB,
        LIBRO.TITLIB TITLIB,
        LIBRO.FECPUBLIB FECPUBLIB,
        LIBRO.PAGLIB PAGLIB,
        LIBRO.DESCLIB DESCLIB,
        LIBRO.TAMLIB TAMLIB,
        PERSONA.NOMPER NOMPER,
        PERSONA.APEPER APEPER,
        PERSONA.ESTPER ESTPER,
        GENERO.NOMGEN NOMGEN,
        GENERO.ESTGEN ESTGEN,
        EDITORIAL.NOMEDIT NOMEDIT,
        EDITORIAL.ESTEDIT ESTEDIT,
        ANAQUEL.NOMANQ NOMANQ,
        ANAQUEL.ESTANQ ESTANQ,
    CASE ESTLIB WHEN 'A' THEN 'Disponible' WHEN 'I' THEN 'No Disponible' END AS ESTLIB
    FROM LIBRO
    INNER JOIN PERSONA ON PERSONA.CODPER = LIBRO.CODAUT
    INNER JOIN GENERO ON GENERO.CODGEN = LIBRO.CODGEN
    INNER JOIN EDITORIAL ON EDITORIAL.CODEDIT = LIBRO.CODEDIT
    INNER JOIN ANAQUEL ON ANAQUEL.CODANQ = LIBRO.CODANQ
;
--------------------------------------------------------
--  DDL for View VW_PRESTAMO
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VW_PRESTAMO" ("CODPRE", "FECSALPRE", "FECDEVPRE", "ESTPRE", "CODPER", "PERSONA") AS 
  select CODPRE,TO_CHAR(FECSALPRE, 'DD/MM/YYYY') AS FECSALPRE,TO_CHAR(FECDEVPRE, 'DD/MM/YYYY') AS FECDEVPRE,ESTPRE,Persona.CODPER as CODPER,Concat(Persona.NOMPER,concat(' ',Persona.APEPER)) as Persona
from Prestamo
inner join Persona
on Persona.CODPER = Prestamo.CODPER
;
--------------------------------------------------------
--  DDL for View VW_PRESTAMODETALLE
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VW_PRESTAMODETALLE" ("CODPREDET", "CODPRE", "PRESTAMO", "CODLIB", "LIBRO") AS 
  select CODPREDET,Prestamo.CODPRE as CODPRE,Concat(TO_CHAR(FECSALPRE, 'DD/MM/YYYY'),concat(' hasta ',TO_CHAR(FECDEVPRE, 'DD/MM/YYYY'))) as Prestamo,Libro.CODLIB as CODLIB,Libro.TITLIB as Libro
from Prestamo_Detalle
inner join Prestamo
on Prestamo.CODPRE = Prestamo_Detalle.CODPRE
inner join Libro
on Libro.CODLIB = Prestamo_Detalle.CODLIB
;
--------------------------------------------------------
--  DDL for Sequence ANAQUEL_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ANAQUEL_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence EDITORIAL_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "EDITORIAL_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence GENERO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "GENERO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence LIBRO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LIBRO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PERSONA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PERSONA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PRESTAMO_DETALLE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRESTAMO_DETALLE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PRESTAMO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRESTAMO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TIPO_LIBRO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TIPO_LIBRO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE ;

--------------------------------------------------------
--  DDL for Index PERSONA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PERSONA_PK" ON "PERSONA" ("CODPER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRESTAMO_DETALLE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRESTAMO_DETALLE_PK" ON "PRESTAMO_DETALLE" ("CODPREDET") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ANAQUEL_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ANAQUEL_PK" ON "ANAQUEL" ("CODANQ") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TIPO_LIBRO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TIPO_LIBRO_PK" ON "TIPO_LIBRO" ("CODTIPOLIB") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index LIBRO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LIBRO_PK" ON "LIBRO" ("CODLIB") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index EDITORIAL_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EDITORIAL_PK" ON "EDITORIAL" ("CODEDIT") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRESTAMO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRESTAMO_PK" ON "PRESTAMO" ("CODPRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index GENERO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GENERO_PK" ON "GENERO" ("CODGEN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger ANAQUEL_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "ANAQUEL_TRG" 
    BEFORE INSERT ON ANAQUEL 
    FOR EACH ROW 
     WHEN ( new.CODANQ IS NULL ) BEGIN
  SELECT ANAQUEL_SEQ.NEXTVAL 
  INTO :new.CODANQ
  FROM dual;
END ANAQUEL_TRG; 

/
ALTER TRIGGER "ANAQUEL_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger EDITORIAL_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "EDITORIAL_TRG" 
    BEFORE INSERT ON EDITORIAL 
    FOR EACH ROW 
     WHEN ( new.CODEDIT IS NULL ) BEGIN
  SELECT EDITORIAL_SEQ.NEXTVAL 
  INTO :new.CODEDIT
  FROM dual;
END EDITORIAL_TRG; 

/
ALTER TRIGGER "EDITORIAL_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger GENERO_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GENERO_TRG" 
    BEFORE INSERT ON GENERO 
    FOR EACH ROW 
     WHEN ( new.CODGEN IS NULL ) BEGIN
  SELECT GENERO_SEQ.NEXTVAL 
  INTO :new.CODGEN
  FROM dual;
END GENERO_TRG; 

/
ALTER TRIGGER "GENERO_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger LIBRO_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LIBRO_TRG" 
    BEFORE INSERT ON LIBRO 
    FOR EACH ROW 
     WHEN ( new.CODLIB IS NULL ) BEGIN
  SELECT LIBRO_SEQ.NEXTVAL 
  INTO :new.CODLIB
  FROM dual;
END LIBRO_TRG; 

/
ALTER TRIGGER "LIBRO_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PERSONA_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PERSONA_TRG" 
    BEFORE INSERT ON PERSONA 
    FOR EACH ROW 
     WHEN ( new.CODPER IS NULL ) BEGIN
  SELECT PERSONA_SEQ.NEXTVAL 
  INTO :new.CODPER
  FROM dual;
END PERSONA_TRG; 

/
ALTER TRIGGER "PERSONA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PRESTAMO_DETALLE_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRESTAMO_DETALLE_TRG" 
    BEFORE INSERT ON PRESTAMO_DETALLE 
    FOR EACH ROW 
     WHEN ( new.CODPREDET IS NULL ) BEGIN
  SELECT PRESTAMO_DETALLE_SEQ.NEXTVAL 
  INTO :new.CODPREDET
  FROM dual;
END PRESTAMO_DETALLE_TRG; 

/
ALTER TRIGGER "PRESTAMO_DETALLE_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PRESTAMO_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRESTAMO_TRG" 
    BEFORE INSERT ON PRESTAMO 
    FOR EACH ROW 
     WHEN ( new.CODPRE IS NULL ) BEGIN
  SELECT PRESTAMO_SEQ.NEXTVAL 
  INTO :new.CODPRE
  FROM dual;
END PRESTAMO_TRG; 

/
ALTER TRIGGER "PRESTAMO_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TIPO_LIBRO_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TIPO_LIBRO_TRG" 
    BEFORE INSERT ON TIPO_LIBRO 
    FOR EACH ROW 
     WHEN ( new.CODTIPOLIB IS NULL ) BEGIN
  SELECT TIPO_LIBRO_SEQ.NEXTVAL 
  INTO :new.CODTIPOLIB
  FROM dual;
END TIPO_LIBRO_TRG; 

/
ALTER TRIGGER "TIPO_LIBRO_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table PERSONA
--------------------------------------------------------

  ALTER TABLE "PERSONA" ADD CONSTRAINT "PERSONA_PK" PRIMARY KEY ("CODPER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PERSONA" MODIFY ("CODPER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRESTAMO
--------------------------------------------------------

  ALTER TABLE "PRESTAMO" ADD CONSTRAINT "PRESTAMO_PK" PRIMARY KEY ("CODPRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PRESTAMO" MODIFY ("CODPER" NOT NULL ENABLE);
  ALTER TABLE "PRESTAMO" MODIFY ("CODPRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EDITORIAL
--------------------------------------------------------

  ALTER TABLE "EDITORIAL" ADD CONSTRAINT "EDITORIAL_PK" PRIMARY KEY ("CODEDIT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "EDITORIAL" MODIFY ("CODEDIT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GENERO
--------------------------------------------------------

  ALTER TABLE "GENERO" ADD CONSTRAINT "GENERO_PK" PRIMARY KEY ("CODGEN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "GENERO" MODIFY ("CODGEN" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LIBRO
--------------------------------------------------------

  ALTER TABLE "LIBRO" ADD CONSTRAINT "LIBRO_PK" PRIMARY KEY ("CODLIB")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LIBRO" MODIFY ("CODANQ" NOT NULL ENABLE);
  ALTER TABLE "LIBRO" MODIFY ("CODTIPOLIB" NOT NULL ENABLE);
  ALTER TABLE "LIBRO" MODIFY ("CODEDIT" NOT NULL ENABLE);
  ALTER TABLE "LIBRO" MODIFY ("CODGEN" NOT NULL ENABLE);
  ALTER TABLE "LIBRO" MODIFY ("CODAUT" NOT NULL ENABLE);
  ALTER TABLE "LIBRO" MODIFY ("CODLIB" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ANAQUEL
--------------------------------------------------------

  ALTER TABLE "ANAQUEL" ADD CONSTRAINT "ANAQUEL_PK" PRIMARY KEY ("CODANQ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ANAQUEL" MODIFY ("CODANQ" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRESTAMO_DETALLE
--------------------------------------------------------

  ALTER TABLE "PRESTAMO_DETALLE" ADD CONSTRAINT "PRESTAMO_DETALLE_PK" PRIMARY KEY ("CODPREDET")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PRESTAMO_DETALLE" MODIFY ("CODLIB" NOT NULL ENABLE);
  ALTER TABLE "PRESTAMO_DETALLE" MODIFY ("CODPRE" NOT NULL ENABLE);
  ALTER TABLE "PRESTAMO_DETALLE" MODIFY ("CODPREDET" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TIPO_LIBRO
--------------------------------------------------------

  ALTER TABLE "TIPO_LIBRO" ADD CONSTRAINT "TIPO_LIBRO_PK" PRIMARY KEY ("CODTIPOLIB")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TIPO_LIBRO" MODIFY ("CODTIPOLIB" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table LIBRO
--------------------------------------------------------

  ALTER TABLE "LIBRO" ADD CONSTRAINT "ANAQUEL_LIBRO_CODANQ" FOREIGN KEY ("CODANQ")
	  REFERENCES "ANAQUEL" ("CODANQ") ENABLE;
  ALTER TABLE "LIBRO" ADD CONSTRAINT "EDITORIAL_LIBRO_CODEDIT" FOREIGN KEY ("CODEDIT")
	  REFERENCES "EDITORIAL" ("CODEDIT") ENABLE;
  ALTER TABLE "LIBRO" ADD CONSTRAINT "GENERO_LIBRO_CODGEN" FOREIGN KEY ("CODGEN")
	  REFERENCES "GENERO" ("CODGEN") ENABLE;
  ALTER TABLE "LIBRO" ADD CONSTRAINT "PERSONA_LIBRO_CODPER" FOREIGN KEY ("CODAUT")
	  REFERENCES "PERSONA" ("CODPER") ENABLE;
  ALTER TABLE "LIBRO" ADD CONSTRAINT "TIPOLIBRO_LIBRO_CODTIPOLIB" FOREIGN KEY ("CODTIPOLIB")
	  REFERENCES "TIPO_LIBRO" ("CODTIPOLIB") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRESTAMO
--------------------------------------------------------

  ALTER TABLE "PRESTAMO" ADD CONSTRAINT "PERSONA_PRESTAMO_CODPER" FOREIGN KEY ("CODPER")
	  REFERENCES "PERSONA" ("CODPER") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRESTAMO_DETALLE
--------------------------------------------------------

  ALTER TABLE "PRESTAMO_DETALLE" ADD CONSTRAINT "LIBRO_PRESTAMODETALLE_CODLIB" FOREIGN KEY ("CODLIB")
	  REFERENCES "LIBRO" ("CODLIB") ENABLE;
  ALTER TABLE "PRESTAMO_DETALLE" ADD CONSTRAINT "PRESTAMO_PRESTAMODET_CODPRE" FOREIGN KEY ("CODPRE")
	  REFERENCES "PRESTAMO" ("CODPRE") ENABLE;
--------------------------------------------------------
--  File created - Friday-December-14-2018   
--------------------------------------------------------
REM INSERTING into ANAQUEL
SET DEFINE OFF;
Insert into ANAQUEL (NOMANQ,COLANQ,FILANQ,ESTANQ) values ('AN001','CL101','FL101','A');
Insert into ANAQUEL (NOMANQ,COLANQ,FILANQ,ESTANQ) values ('AN002','CL201','FL201','A');
Insert into ANAQUEL (NOMANQ,COLANQ,FILANQ,ESTANQ) values ('AN003','CL301','FL301','A');
Insert into ANAQUEL (NOMANQ,COLANQ,FILANQ,ESTANQ) values ('AN004','CL401','FL401','A');
Insert into ANAQUEL (NOMANQ,COLANQ,FILANQ,ESTANQ) values ('AN005','CL501','FL501','A');
Insert into ANAQUEL (NOMANQ,COLANQ,FILANQ,ESTANQ) values ('AN006','CL601','FL601','A');
Insert into ANAQUEL (NOMANQ,COLANQ,FILANQ,ESTANQ) values ('AN007','CL701','FL701','A');
Insert into ANAQUEL (NOMANQ,COLANQ,FILANQ,ESTANQ) values ('AN008','CL801','FL801','A');
Insert into ANAQUEL (NOMANQ,COLANQ,FILANQ,ESTANQ) values ('AN009','CL901','FL901','A');
commit;
REM INSERTING into EDITORIAL
SET DEFINE OFF;
Insert into EDITORIAL (NOMEDIT,ESTEDIT) values ('Pierre-Jules Hetzel','A');
Insert into EDITORIAL (NOMEDIT,ESTEDIT) values ('Viking Press','A');
Insert into EDITORIAL (NOMEDIT,ESTEDIT) values ('Weidenfeld and Nicolson, World Publishing Company','A');
Insert into EDITORIAL (NOMEDIT,ESTEDIT) values ('ALIANZA EDITORIAL','A');
Insert into EDITORIAL (NOMEDIT,ESTEDIT) values ('EDITORIAL Nascimento','A');
Insert into EDITORIAL (NOMEDIT,ESTEDIT) values ('Navarrete','A');
Insert into EDITORIAL (NOMEDIT,ESTEDIT) values ('NAVARRETE01','I');
Insert into EDITORIAL (NOMEDIT,ESTEDIT) values ('Editorial','I');
Insert into EDITORIAL (NOMEDIT,ESTEDIT) values ('Lackington','A');
Insert into EDITORIAL (NOMEDIT,ESTEDIT) values ('Talleres de la Penitensiaría de Lima','A');
commit;
REM INSERTING into GENERO
SET DEFINE OFF;
Insert into GENERO (NOMGEN,ESTGEN) values ('Ficcion and Literatura','A');
Insert into GENERO (NOMGEN,ESTGEN) values ('Misterio and Suspenso','A');
Insert into GENERO (NOMGEN,ESTGEN) values ('Historia','A');
Insert into GENERO (NOMGEN,ESTGEN) values ('Drama','A');
Insert into GENERO (NOMGEN,ESTGEN) values ('Poesia','A');
Insert into GENERO (NOMGEN,ESTGEN) values ('Tecnologia','A');
Insert into GENERO (NOMGEN,ESTGEN) values ('Agraria','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('Comedia','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('Musica','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('Comedia','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('Agronomia','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('Geografia','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('Economia','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('Ciencia','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('Tragedia','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('Comedia','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('masculino','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('mario','I');
Insert into GENERO (NOMGEN,ESTGEN) values ('zecarlos','I');
commit;
REM INSERTING into PERSONA
SET DEFINE OFF;
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('admin',null,null,null,null,null,'admin','AD','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('user',null,null,null,null,null,'user','BI','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Jose','Sanchez','56412358','Av.Santiago','987642130','jsanchez@hotmail.com','demo','PR','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Ricardo','Rodriguez','54120021','Av.Las Margaritas','901326451','rrodriguez@hotmail.com','demo','PR','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Juan','Reyna','54846321','Av.EstadosAmericanos','956231456','jreyna@hotmail.com','demo','ES','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Jhon','Paredes','50326841','Av.28 de Julio','971201458','jparedes@hotmail.com','demo','ES','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Miguel','Quispe','56489974','Av.2 de Mayo','963256841','mquispe@hotmail.com','demo','ES','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Julio','Verne',null,null,null,null,null,'AT','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Stephen','King',null,null,null,null,null,'AT','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Eric','Hobsbawm',null,null,null,null,null,'AT','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('William','Shakespeare',null,null,null,null,null,'AT','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Pablo','Neruda',null,null,null,null,null,'AT','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('ZECARLOS','SALCEDO',null,null,null,null,null,'AT','I');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Mario','Vargas llosa',null,null,null,null,null,'AT','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Ricardo','Palma',null,null,null,null,null,'AT','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('zecarlos','salcedo',null,null,null,null,null,'AT','I');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Gabriel','García Márquez',null,null,null,null,null,'AT','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Cesar','Vallejo',null,null,null,null,null,'AT','A');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('DEMO','DEMO01',null,null,null,null,null,'AT','I');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('aa','aa',null,null,null,null,null,'AT','I');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('aa','aaaa',null,null,null,null,null,'AT','I');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('bb','bbb',null,null,null,null,null,'AT','I');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('aa','aa','35325355','aaaas','523532535','ssasas','demo','PR','I');
Insert into PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) values ('Mary','Shelley',null,null,null,null,null,'AT','A');
commit;
REM INSERTING into PRESTAMO
SET DEFINE OFF;
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('09-JAN-18','DD-MON-RR'),to_date('11-JAN-18','DD-MON-RR'),'I',3);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('12-JUN-18','DD-MON-RR'),to_date('15-JUN-18','DD-MON-RR'),'I',4);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('13-APR-18','DD-MON-RR'),to_date('16-APR-18','DD-MON-RR'),'I',5);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('20-AUG-18','DD-MON-RR'),to_date('23-AUG-18','DD-MON-RR'),'I',6);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('25-NOV-18','DD-MON-RR'),to_date('28-NOV-18','DD-MON-RR'),'A',7);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('11-OCT-18','DD-MON-RR'),to_date('14-OCT-18','DD-MON-RR'),'I',3);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('07-DEC-18','DD-MON-RR'),to_date('10-DEC-18','DD-MON-RR'),'A',7);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('10-OCT-18','DD-MON-RR'),to_date('10-OCT-18','DD-MON-RR'),'A',5);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('01-JAN-18','DD-MON-RR'),to_date('04-JAN-18','DD-MON-RR'),'I',4);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('10-OCT-18','DD-MON-RR'),to_date('13-OCT-18','DD-MON-RR'),'A',5);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('14-DEC-18','DD-MON-RR'),to_date('17-DEC-18','DD-MON-RR'),'A',4);
Insert into PRESTAMO (FECSALPRE,FECDEVPRE,ESTPRE,CODPER) values (to_date('14-DEC-18','DD-MON-RR'),to_date('17-DEC-18','DD-MON-RR'),'A',6);
commit;
REM INSERTING into TIPO_LIBRO
SET DEFINE OFF;
Insert into TIPO_LIBRO (NOMTIPOLIB,ESTTIPOLIB) values ('Libro','A');
Insert into TIPO_LIBRO (NOMTIPOLIB,ESTTIPOLIB) values ('Manual','A');
Insert into TIPO_LIBRO (NOMTIPOLIB,ESTTIPOLIB) values ('Revista','A');
Insert into TIPO_LIBRO (NOMTIPOLIB,ESTTIPOLIB) values ('Separata','A');
Insert into TIPO_LIBRO (NOMTIPOLIB,ESTTIPOLIB) values ('Otros','A');
Insert into TIPO_LIBRO (NOMTIPOLIB,ESTTIPOLIB) values ('Imagen','A');
Insert into TIPO_LIBRO (NOMTIPOLIB,ESTTIPOLIB) values ('Video','A');
commit;
REM INSERTING into LIBRO
SET DEFINE OFF;
Insert into LIBRO (ISBNLIB,TITLIB,FECPUBLIB,CODAUT,CODGEN,CODEDIT,PAGLIB,DESCLIB,TAMLIB,CODTIPOLIB,CODANQ,ESTLIB) values ('2346591302134','Viaje al centro de la Tierra',to_date('01-DEC-64','DD-MON-RR'),8,1,1,'361','Trata de la expedicion de un profesor de mineralogia, su sobrino y un guia al interior del globo o al interior de la Tierra.','15cm',1,1,'A');
Insert into LIBRO (ISBNLIB,TITLIB,FECPUBLIB,CODAUT,CODGEN,CODEDIT,PAGLIB,DESCLIB,TAMLIB,CODTIPOLIB,CODANQ,ESTLIB) values ('4346413154642','It',to_date('01-DEC-86','DD-MON-RR'),9,2,2,'1132','Cuenta la historia de un grupo de siete niños que son aterrorizados por un malvado monstruo -al que llaman Eso- que es capaz de cambiar de forma, alimentandose del terror que produce en sus victimas.','18cm',1,2,'A');
Insert into LIBRO (ISBNLIB,TITLIB,FECPUBLIB,CODAUT,CODGEN,CODEDIT,PAGLIB,DESCLIB,TAMLIB,CODTIPOLIB,CODANQ,ESTLIB) values ('8521201256320','La era de la revolucion, 1789-1848',to_date('12-DEC-62','DD-MON-RR'),10,3,3,'366','La era de la revolucion inicia el panorama de la historia contemporanea del mundo que Eric Hobsbawm comenzo con este libro y que ha concluido recientemente con su Historia del siglo XX.','16cm',1,3,'A');
Insert into LIBRO (ISBNLIB,TITLIB,FECPUBLIB,CODAUT,CODGEN,CODEDIT,PAGLIB,DESCLIB,TAMLIB,CODTIPOLIB,CODANQ,ESTLIB) values ('7441354631456','Hamlet',to_date('12-DEC-09','DD-MON-RR'),11,4,4,'240','Es una tragedia del dramaturgo ingles William Shakespeare. Su autor probablemente baso Hamlet en dos fuentes: la leyenda de Amleth y una perdida obra isabelina conocida hoy como Ur-Hamlet o Hamlet original.','20cm',1,4,'A');
Insert into LIBRO (ISBNLIB,TITLIB,FECPUBLIB,CODAUT,CODGEN,CODEDIT,PAGLIB,DESCLIB,TAMLIB,CODTIPOLIB,CODANQ,ESTLIB) values ('5464831156152','Veinte poemas de amor y una cancion desesperada',to_date('12-DEC-24','DD-MON-RR'),12,5,5,'92','Es una de las más célebres obras del poeta chileno Pablo Neruda. Publicado en 1924, el poemario lanzo a su autor a la fama con apenas 19 años de edad, y es una de las obras literarias de mayor renombre del siglo XX en la lengua española.','18cm',1,5,'A');
Insert into LIBRO (ISBNLIB,TITLIB,FECPUBLIB,CODAUT,CODGEN,CODEDIT,PAGLIB,DESCLIB,TAMLIB,CODTIPOLIB,CODANQ,ESTLIB) values ('1023151050864','Cien años de soledad',to_date('12-DEC-82','DD-MON-RR'),17,1,2,'471','Es considerada una obra maestra de la literatura hispanoamericana y universal, asi como una de las obras más traducidas y leídas en español.','12cm',1,6,'I');
Insert into LIBRO (ISBNLIB,TITLIB,FECPUBLIB,CODAUT,CODGEN,CODEDIT,PAGLIB,DESCLIB,TAMLIB,CODTIPOLIB,CODANQ,ESTLIB) values ('6468435435454','Frankenstein',to_date('12-DEC-23','DD-MON-RR'),24,1,9,'249','Frankenstein o el moderno Prometeo, habla de temas tales como la moral científica, la creación y destrucción de vida y el atrevimiento de la humanidad en su relación con Dios. ','15cm',1,1,'A');
Insert into LIBRO (ISBNLIB,TITLIB,FECPUBLIB,CODAUT,CODGEN,CODEDIT,PAGLIB,DESCLIB,TAMLIB,CODTIPOLIB,CODANQ,ESTLIB) values ('7624674276256','Trilce',to_date('12-DEC-22','DD-MON-RR'),18,5,10,'107','Trilce es el poemario más importante y conocido del poeta peruano César Vallejo, y está considerado, merced a sus audacias lexicográficas y sintácticas, como una obra capital de la poesía universal moderna y obra cumbre de la Vanguardia poética en lengua española.','12cm',1,2,'A');
commit;
REM INSERTING into PRESTAMO_DETALLE
SET DEFINE OFF;
Insert into PRESTAMO_DETALLE (CODPRE,CODLIB) values (1,1);
Insert into PRESTAMO_DETALLE (CODPRE,CODLIB) values (2,2);
Insert into PRESTAMO_DETALLE (CODPRE,CODLIB) values (3,3);
Insert into PRESTAMO_DETALLE (CODPRE,CODLIB) values (4,4);
Insert into PRESTAMO_DETALLE (CODPRE,CODLIB) values (5,5);
Insert into PRESTAMO_DETALLE (CODPRE,CODLIB) values (1,2);
commit;
