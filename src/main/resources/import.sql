INSERT INTO reimburse.grade (id, give_birth_cost, glasess_cost, hotel_cost, meal_cost, grade, transportation_cost) VALUES ('66f196da-8973-40cf-8e17-80b54cfedba7', '100000', '150000', '300000', '200000', '1', '150000');
INSERT INTO reimburse.grade (id, give_birth_cost, glasess_cost, hotel_cost, meal_cost, grade, transportation_cost) VALUES ('7a0a4a9b-0374-4fbc-88c0-1fe23e824ece', '200000', '200000', '400000', '300000', '2', '200000');
INSERT INTO reimburse.grade (id, give_birth_cost, glasess_cost, hotel_cost, meal_cost, grade, transportation_cost) VALUES ('fb31c00d-89d3-48b2-a5ef-c150d6d7d4b9', '300000', '250000', '500000', '400000', '3', '300000');
INSERT INTO reimburse.grade (id, give_birth_cost, glasess_cost, hotel_cost, meal_cost, grade, transportation_cost) VALUES ('d17590e0-9ec4-4fe5-a513-fe533f10fead', '400000', '300000', '600000', '500000', '4', '400000');


INSERT INTO reimburse.category (id, category_name) VALUES ('1e4bbbee-83f3-11eb-8dcd-0242ac130003', 'glasses');
INSERT INTO reimburse.category (id, category_name) VALUES ('1e4bbbee-83f3-11eb-8dcd-0242ac130004', 'training');
INSERT INTO reimburse.category (id, category_name) VALUES ('1e4bbbee-83f3-11eb-8dcd-0242ac130005', 'give_birth');
INSERT INTO reimburse.category (id, category_name) VALUES ('71ff287a-83f3-11eb-8dcd-0242ac130003', 'official_travel');
INSERT INTO reimburse.category (id, category_name) VALUES ('71ff287a-83f3-11eb-8dcd-0242ac130098', 'insurance');



INSERT INTO role(id,created_date,role_name) VALUES (1,'2021-03-13','super_admin');
INSERT INTO role(id,created_date,role_name) VALUES (2,'2021-03-14','admin_finance');
INSERT INTO role(id,created_date,role_name) VALUES (3,'2021-03-16','assistance_admin');
INSERT INTO role(id,created_date,role_name) VALUES (4,'2021-03-17','employee');

INSERT INTO reimburse.login (id, created_date, email, password, id_role) VALUES ('58b184ed-b256-4762-92cd-0c67206e0548', '2021-12-1', 'wisa@gmail.com', 'wisa', '1');
INSERT INTO reimburse.login (id, created_date, email, password, id_role) VALUES ('7b225550-51a9-492c-beea-ce4d807f1eda', '2021-12-2', 'irfan@gmail.com', 'irfan', '2');
INSERT INTO reimburse.login (id, created_date, email, password, id_role) VALUES ('6c1d0c8c-4296-4e67-a04b-3c3fdaa158b7', '2021-12-3', 'wulan@gmail.com', 'wulan', '3');
INSERT INTO reimburse.login (id, created_date, email, password, id_role) VALUES ('b884462e-83e7-11eb-8dcd-0242ac130003', '2021-12-4', 'eka@gmail.com', 'eka', '4');
INSERT INTO reimburse.login (id, created_date, email, password, id_role) VALUES ('aa', '2021-12-4', 'ahmadirfaanh@gmail.com', 'danielanjing', '4');
INSERT INTO reimburse.login (id, created_date, email, password, id_role) VALUES ('bb', '2021-12-4', 'tuti@gmail.com', 'tuti', '4');
INSERT INTO reimburse.login (id, created_date, email, password, id_role) VALUES ('cc', '2021-12-4', 'wisaaa@gmail.com', 'wisa', '4');
INSERT INTO reimburse.login (id, created_date, email, password, id_role) VALUES ('dd', '2021-12-4', 'ekaaaa@gmail.com', 'eka', '4');

INSERT INTO reimburse.employee(id, created_date ,id_login, fullname, account_name, account_number, biological_mother_name, date_of_birth,emergency_number, ktp_address, employee_type, employee_status, gender,join_date, npwp_address,phone_number, place_of_birth, postal_code_of_id_card, religion,residence_address, marital_status,blood_type, number_of_children, spouse_name,npwp, nik, nip,is_verified_hc,is_verified_email) VALUES ('abcd','2021-12-4', 'bb', 'Tuti Wulandari','bri','321205151515','nurul aida','1998-07-17','085318919533','indramayu','1','1','MALE', '2021-04-20','indramayu','085323182016','indramayu','45261','ISLAM','jakarta','SINGLE','A',0,'Belum ada','12345678','3212055707980002','14061015900',TRUE,TRUE);
INSERT INTO reimburse.employee(id, created_date ,id_login, fullname, account_name, account_number, biological_mother_name, date_of_birth,emergency_number, ktp_address, employee_type, employee_status, gender,join_date, npwp_address,phone_number, place_of_birth, postal_code_of_id_card, religion,residence_address, marital_status,blood_type, number_of_children, spouse_name,npwp, nik, nip,is_verified_hc,is_verified_email) VALUES ('abce','2021-12-4', 'bb', ' Wisa','bri','321205151515','nurul aida','1998-07-17','085318919533','indramayu','1','1','MALE', '2021-04-20','indramayu','085323182016','indramayu','45261','ISLAM','jakarta','SINGLE','A',0,'Belum ada','12345678','3212055707980002','14061015900',TRUE,TRUE);
INSERT INTO reimburse.employee(id, created_date ,id_login, fullname, account_name, account_number, biological_mother_name, date_of_birth,emergency_number, ktp_address, employee_type, employee_status, gender,join_date, npwp_address,phone_number, place_of_birth, postal_code_of_id_card, religion,residence_address, marital_status,blood_type, number_of_children, spouse_name,npwp, nik, nip,is_verified_hc,is_verified_email) VALUES ('abcf','2021-12-4', 'bb', 'irfan','bri','321205151515','nurul aida','1998-07-17','085318919533','indramayu','1','1','MALE', '2021-04-20','indramayu','085323182016','indramayu','45261','ISLAM','jakarta','SINGLE','A',0,'Belum ada','12345678','3212055707980002','14061015900',TRUE,TRUE);
INSERT INTO reimburse.employee(id, created_date ,id_login, fullname, account_name, account_number, biological_mother_name, date_of_birth,emergency_number, ktp_address, employee_type, employee_status, gender,join_date, npwp_address,phone_number, place_of_birth, postal_code_of_id_card, religion,residence_address, marital_status,blood_type, number_of_children, spouse_name,npwp, nik, nip,is_verified_hc,is_verified_email) VALUES ('abcg','2021-12-4', 'bb', 'eka','bri','321205151515','nurul aida','1998-07-17','085318919533','indramayu','1','1','MALE', '2021-04-20','indramayu','085323182016','indramayu','45261','ISLAM','jakarta','SINGLE','A',0,'Belum ada','12345678','3212055707980002','14061015900',TRUE,TRUE);


INSERT INTO admin (id,created_date,name,id_login) VALUES ('f924cdd8-2d3c-4b35-8f5b-1a0ccc142c0b','2021-03-10','wisa','58b184ed-b256-4762-92cd-0c67206e0548');
INSERT INTO admin (id,created_date,name,id_login) VALUES ('8b2558c0-2d0f-45e2-a063-617a9ab4f6c7','2021-03-11','irfan','7b225550-51a9-492c-beea-ce4d807f1eda');
INSERT INTO admin (id,created_date,name,id_login) VALUES ('02564c68-c872-43ee-a67a-57d91de2b1b1','2021-03-12','wulan','6c1d0c8c-4296-4e67-a04b-3c3fdaa158b7');
INSERT INTO admin (id,created_date,name,id_login) VALUES ('742cb4d1-060b-421d-bbbc-093d8113040e','2021-03-13','eka','b884462e-83e7-11eb-8dcd-0242ac130003');

INSERT INTO reimburse.reimbursement (id, created_date, borne_cost, claim_fee, date_of_claim_submission, disbursement_date, status_on_finance, status_on_hc, status_reject, status_success, id_category, id_employee) VALUES ('ec618aec-da9c-4e21-b633-0584c6fbc472', '2020-12-12', '120000', '120000', '2021-1-12', '2021-4-12', b'0', b'1', b'0', b'1', '71ff287a-83f3-11eb-8dcd-0242ac130003', 'abcd');
INSERT INTO reimburse.reimbursement (id, created_date, borne_cost, claim_fee, date_of_claim_submission, disbursement_date, status_on_finance, status_on_hc, status_reject, status_success, id_category, id_employee) VALUES ('cf3333a5-b5ce-4637-9cd4-205150fce077', '2020-12-12', '120000', '120000', '2021-3-12', '2021-4-12', b'1', b'0', b'0', b'1', '71ff287a-83f3-11eb-8dcd-0242ac130098', 'defg');
INSERT INTO reimburse.reimbursement (id, created_date, borne_cost, claim_fee, date_of_claim_submission, disbursement_date, status_on_finance, status_on_hc, status_reject, status_success, id_category, id_employee) VALUES ('ce59d566-76a6-4e67-bb11-279f7c880229', '2020-12-12', '120000', '120000', '2021-1-12', '2021-4-12', b'1', b'1', b'0', b'1', '1e4bbbee-83f3-11eb-8dcd-0242ac130003', 'abcd');


--
-- INSERT INTO reimburse.reimbursement_detail_insurance (id, type_of_insurance, id_reimbursement) VALUES ('4283883e-aba1-4e5c-a4ff-6f26bbd41154', 'Rawat Inap', 'ce59d566-76a6-4e67-bb11-279f7c880229');
-- INSERT INTO reimburse.reimbursement_detail_insurance (id, type_of_insurance, id_reimbursement) VALUES ('ac276a07-5796-4de2-b913-940f50c244be', 'Rawat Inap', 'ce59d566-76a6-4e67-bb11-279f7c880229');
-- INSERT INTO reimburse.reimbursement_detail_insurance (id, type_of_insurance, id_reimbursement) VALUES ('c7ddcf3d-bc3c-4172-b201-646040c5cea0', 'Rawat Inap', 'ce59d566-76a6-4e67-bb11-279f7c880229');
-- INSERT INTO reimburse.reimbursement_detail_insurance (id, type_of_insurance, id_reimbursement) VALUES ('5b6a4b3a-c3ec-4683-bbd0-a0d4e2b8b731', 'Rawat Inap', 'ce59d566-76a6-4e67-bb11-279f7c880229');
--
-- INSERT INTO reimburse.reimbursement_give_birth (id, labor_cost, id_reimbursement) VALUES ('cceb341d-e84c-4883-8e6e-63529380d7bc', '700000', 'cf3333a5-b5ce-4637-9cd4-205150fce077');
-- INSERT INTO reimburse.reimbursement_give_birth (id, labor_cost, id_reimbursement) VALUES ('69023885-8b5c-44d1-aa12-8f38258f9697', '800000', 'cf3333a5-b5ce-4637-9cd4-205150fce077');
-- INSERT INTO reimburse.reimbursement_give_birth (id, labor_cost, id_reimbursement) VALUES ('0c5a778d-3cb6-4d57-a9c8-5c2a58174951', '900000', 'cf3333a5-b5ce-4637-9cd4-205150fce077');
-- INSERT INTO reimburse.reimbursement_give_birth (id, labor_cost, id_reimbursement) VALUES ('fb0710e0-33af-4682-93c8-98639d56d871', '500000', 'cf3333a5-b5ce-4637-9cd4-205150fce077');
-- INSERT INTO reimburse.reimbursement_give_birth (id, labor_cost, id_reimbursement) VALUES ('2952d17f-5003-4d72-8941-602ac69d1ae2', '700000', 'cf3333a5-b5ce-4637-9cd4-205150fce077');

-- INSERT INTO reimburse.reimbursement_glasess (id, created_date, borne_costs, id_reimbursement) VALUES ('2952d17f-5003-4d72-8941-602ac69d1ae2', '2020-12-12', '120000', 'ce59d566-76a6-4e67-bb11-279f7c880229');
-- INSERT INTO reimburse.reimbursement_glasess (id, created_date, borne_costs, id_reimbursement) VALUES ('5b1a5abe-a551-482d-bcd1-bb96d79bc192', '2020-12-15', '200000', 'ce59d566-76a6-4e67-bb11-279f7c880229');
-- INSERT INTO reimburse.reimbursement_glasess (id, created_date, borne_costs, id_reimbursement) VALUES ('92afe65d-f69d-4479-8c5a-8c69da1d89d7', '2020-12-18', '150000', 'ce59d566-76a6-4e67-bb11-279f7c880229');
-- INSERT INTO reimburse.reimbursement_glasess (id, created_date, borne_costs, id_reimbursement) VALUES ('47980eae-7a0f-4a30-92a5-f7eb74644097', '2020-12-20', '300000', 'ce59d566-76a6-4e67-bb11-279f7c880229');
--
-- INSERT INTO reimburse.reimbursement_insurance (id, created_date, borne_cost, id_reimbursement) VALUES ('c6f7a014-cb57-4256-a4e0-4450b5b4bedb', '2020-12-1', '130000', 'cf3333a5-b5ce-4637-9cd4-205150fce077');
-- INSERT INTO reimburse.reimbursement_insurance (id, created_date, borne_cost, id_reimbursement) VALUES ('82308251-7907-41dc-8697-d48b96c25e25', '2020-12-15', '200000', 'cf3333a5-b5ce-4637-9cd4-205150fce077');
-- INSERT INTO reimburse.reimbursement_insurance (id, created_date, borne_cost, id_reimbursement) VALUES ('237286fb-d13d-4c70-b829-6de3c62eed9c', '2020-12-19', '150000', 'cf3333a5-b5ce-4637-9cd4-205150fce077');
--
-- INSERT INTO reimburse.reimbursement_training (id, created_date, training_end_date, training_start_date, id_reimbursement) VALUES ('89346379-24fa-4adb-8e47-b446208544e4', '2020-12-12', '2021-2-8', '2021-2-10', 'ce59d566-76a6-4e67-bb11-279f7c880229');
-- INSERT INTO reimburse.reimbursement_training (id, created_date, training_end_date, training_start_date, id_reimbursement) VALUES ('d63208e7-9406-41a3-8b29-7a3a96ef8798', '2020-12-18', '2021-2-10', '2021-2-17', 'cf3333a5-b5ce-4637-9cd4-205150fce077');
-- INSERT INTO reimburse.reimbursement_training (id, created_date, training_end_date, training_start_date, id_reimbursement) VALUES ('8f4384c0-8983-468e-9078-16d0e09c5653', '2020-12-20', '2021-2-15', '2021-2-17', 'ec618aec-da9c-4e21-b633-0584c6fbc472');
--
-- INSERT INTO reimburse.reimbursement_travel (id, created_date, end_date, start_date, id_reimbursement) VALUES ('99b83565-5d39-4173-b5a3-a3deb062a9fe', '2020-12-10', '2020-12-10', '2020-12-5', 'ce59d566-76a6-4e67-bb11-279f7c880229');
-- INSERT INTO reimburse.reimbursement_travel (id, created_date, end_date, start_date, id_reimbursement) VALUES ('565a348c-8d11-42ac-b040-ef1bf029ebfa', '2020-12-20', '2020-12-19', '2020-12-7', 'cf3333a5-b5ce-4637-9cd4-205150fce077');
-- INSERT INTO reimburse.reimbursement_travel (id, created_date, end_date, start_date, id_reimbursement) VALUES ('30e1e210-d7a5-44ef-99a1-c6a846fe1d39', '2020-12-20', '2020-12-15', '2020-12-8', 'cf3333a5-b5ce-4637-9cd4-205150fce077');
-- INSERT INTO reimburse.reimbursement_travel (id, created_date, end_date, start_date, id_reimbursement) VALUES ('52a56c8a-b6b1-47b7-aae8-4048306df82a', '2020-12-20', '2020-12-31', '2020-12-16', 'ec618aec-da9c-4e21-b633-0584c6fbc472');

INSERT INTO reimburse.bill (id, created_date, bill_image, id_reimbursement) VALUES ('bd63b7fe-85ce-44ac-9f51-d30326ff5fbd', '2021-2-15', 'huibyggygytf.jpg', 'ce59d566-76a6-4e67-bb11-279f7c880229');
INSERT INTO reimburse.bill (id, created_date, bill_image, id_reimbursement) VALUES ('d8225d5b-7a4a-4961-8402-c6b343fe5073', '2021-2-15', 'huibyggygytf.jpg', 'ce59d566-76a6-4e67-bb11-279f7c880229');
INSERT INTO reimburse.bill (id, created_date, bill_image, id_reimbursement) VALUES ('fa546142-d03b-4775-b13d-da988aff2391', '2021-2-15', 'huibyggygytf.jpg', 'ce59d566-76a6-4e67-bb11-279f7c880229');
INSERT INTO reimburse.bill (id, created_date, bill_image, id_reimbursement) VALUES ('f5cb44ba-19a8-4d56-92ea-d61736ddcccf', '2021-2-15', 'huibyggygytf.jpg', 'ce59d566-76a6-4e67-bb11-279f7c880229');