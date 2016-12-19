--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.7
-- Dumped by pg_dump version 9.4.7
-- Started on 2016-12-13 07:42:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2026 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 176 (class 1259 OID 593286)
-- Name: comentario_id_comentario_seq; Type: SEQUENCE; Schema: public; Owner: forum
--

CREATE SEQUENCE comentario_id_comentario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comentario_id_comentario_seq OWNER TO forum;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 177 (class 1259 OID 593288)
-- Name: comentario; Type: TABLE; Schema: public; Owner: forum; Tablespace: 
--

CREATE TABLE comentario (
    id_comentario integer DEFAULT nextval('comentario_id_comentario_seq'::regclass) NOT NULL,
    comentario text,
    login text,
    id_topico integer
);


ALTER TABLE comentario OWNER TO forum;

--
-- TOC entry 174 (class 1259 OID 593270)
-- Name: topico_id_topico_seq; Type: SEQUENCE; Schema: public; Owner: forum
--

CREATE SEQUENCE topico_id_topico_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE topico_id_topico_seq OWNER TO forum;

--
-- TOC entry 175 (class 1259 OID 593272)
-- Name: topico; Type: TABLE; Schema: public; Owner: forum; Tablespace: 
--

CREATE TABLE topico (
    id_topico integer DEFAULT nextval('topico_id_topico_seq'::regclass) NOT NULL,
    titulo text,
    conteudo text,
    login text
);


ALTER TABLE topico OWNER TO forum;

--
-- TOC entry 173 (class 1259 OID 593262)
-- Name: usuario; Type: TABLE; Schema: public; Owner: forum; Tablespace: 
--

CREATE TABLE usuario (
    login text NOT NULL,
    email text,
    nome text,
    senha text,
    pontos integer
);


ALTER TABLE usuario OWNER TO forum;

--
-- TOC entry 2018 (class 0 OID 593288)
-- Dependencies: 177
-- Data for Name: comentario; Type: TABLE DATA; Schema: public; Owner: forum
--



--
-- TOC entry 2027 (class 0 OID 0)
-- Dependencies: 176
-- Name: comentario_id_comentario_seq; Type: SEQUENCE SET; Schema: public; Owner: forum
--

SELECT pg_catalog.setval('comentario_id_comentario_seq', 1, false);


--
-- TOC entry 2016 (class 0 OID 593272)
-- Dependencies: 175
-- Data for Name: topico; Type: TABLE DATA; Schema: public; Owner: forum
--

INSERT INTO topico VALUES (4, 'Teste', 'conteudo', 'oi');
INSERT INTO topico VALUES (5, 'Agora foi', 'mas bah guri', 'oi');
INSERT INTO topico VALUES (6, 'titulo do topic', 'descricao', 'oi');
INSERT INTO topico VALUES (7, 'test post', 'post do test', 'oi');
INSERT INTO topico VALUES (8, 'Bacana', 'o nome da parade e comentÃ¡rios', 'skeeter');


--
-- TOC entry 2028 (class 0 OID 0)
-- Dependencies: 174
-- Name: topico_id_topico_seq; Type: SEQUENCE SET; Schema: public; Owner: forum
--

SELECT pg_catalog.setval('topico_id_topico_seq', 8, true);


--
-- TOC entry 2014 (class 0 OID 593262)
-- Dependencies: 173
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: forum
--

INSERT INTO usuario VALUES ('skeeter', 'newtonmuchael@gmail.com', 'Newton', '1234', 50);
INSERT INTO usuario VALUES ('oi', 'oi@oi.com', 'oi', 'oi', 10);
INSERT INTO usuario VALUES ('teste', 'teste@mail.com', 'Teste', '1234', 15);


--
-- TOC entry 1901 (class 2606 OID 593296)
-- Name: comentario_pkey; Type: CONSTRAINT; Schema: public; Owner: forum; Tablespace: 
--

ALTER TABLE ONLY comentario
    ADD CONSTRAINT comentario_pkey PRIMARY KEY (id_comentario);


--
-- TOC entry 1899 (class 2606 OID 593280)
-- Name: topico_pkey; Type: CONSTRAINT; Schema: public; Owner: forum; Tablespace: 
--

ALTER TABLE ONLY topico
    ADD CONSTRAINT topico_pkey PRIMARY KEY (id_topico);


--
-- TOC entry 1897 (class 2606 OID 593269)
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: forum; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (login);


--
-- TOC entry 1903 (class 2606 OID 593297)
-- Name: comentario_id_topico_fkey; Type: FK CONSTRAINT; Schema: public; Owner: forum
--

ALTER TABLE ONLY comentario
    ADD CONSTRAINT comentario_id_topico_fkey FOREIGN KEY (id_topico) REFERENCES topico(id_topico);


--
-- TOC entry 1904 (class 2606 OID 593302)
-- Name: comentario_login_fkey; Type: FK CONSTRAINT; Schema: public; Owner: forum
--

ALTER TABLE ONLY comentario
    ADD CONSTRAINT comentario_login_fkey FOREIGN KEY (login) REFERENCES usuario(login);


--
-- TOC entry 1902 (class 2606 OID 593281)
-- Name: topico_login_fkey; Type: FK CONSTRAINT; Schema: public; Owner: forum
--

ALTER TABLE ONLY topico
    ADD CONSTRAINT topico_login_fkey FOREIGN KEY (login) REFERENCES usuario(login);


--
-- TOC entry 2025 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: forum
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM forum;
GRANT ALL ON SCHEMA public TO forum;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-12-13 07:42:31

--
-- PostgreSQL database dump complete
--

