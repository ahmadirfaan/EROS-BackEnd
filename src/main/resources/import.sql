INSERT INTO grade (id, give_birth_cost, glasess_cost, hotel_cost, meal_cost, grade, transportation_cost) VALUES ('1', '100000', '150000', '300000', '200000', '1', '150000');
INSERT INTO grade (id, give_birth_cost, glasess_cost, hotel_cost, meal_cost, grade, transportation_cost) VALUES ('2', '200000', '200000', '400000', '300000', '2', '200000');
INSERT INTO grade (id, give_birth_cost, glasess_cost, hotel_cost, meal_cost, grade, transportation_cost) VALUES ('3', '300000', '250000', '500000', '400000', '3', '300000');
INSERT INTO grade (id, give_birth_cost, glasess_cost, hotel_cost, meal_cost, grade, transportation_cost) VALUES ('4', '400000', '300000', '600000', '500000', '4', '400000');


INSERT INTO category (id, category_name) VALUES ('1', 'glasses');
INSERT INTO category (id, category_name) VALUES ('2', 'training');
INSERT INTO category (id, category_name) VALUES ('3', 'give_birth');
INSERT INTO category (id, category_name) VALUES ('4', 'official_travel');
INSERT INTO category (id, category_name) VALUES ('5', 'insurance');


INSERT INTO role(id,created_date,role_name) VALUES (1,'2021-03-13','super_admin');
INSERT INTO role(id,created_date,role_name) VALUES (2,'2021-03-14','admin_finance');
INSERT INTO role(id,created_date,role_name) VALUES (3,'2021-03-16','assistance_admin');
INSERT INTO role(id,created_date,role_name) VALUES (4,'2021-03-17','employee');


INSERT INTO login (id, created_date, email, password, id_role) VALUES ('1', '2021-12-1', 'wisa@gmail.com', 'wisa', 1);
INSERT INTO login (id, created_date, email, password, id_role) VALUES ('2', '2021-12-2', 'irfan@gmail.com', 'irfan', 2);
INSERT INTO login (id, created_date, email, password, id_role) VALUES ('3', '2021-12-3', 'wulan@gmail.com', 'wulan', 3);
INSERT INTO login (id, created_date, email, password, id_role) VALUES ('4', '2021-12-4', 'eka@gmail.com', 'eka', 4);


INSERT INTO employee(id, created_date, id_login, fullname, account_name, account_number, biological_mother_name, date_of_birth,emergency_number, ktp_address, employee_type, employee_status, gender,join_date, npwp_address,phone_number, place_of_birth, postal_code_of_id_card, religion,residence_address, marital_status,blood_type, number_of_children, spouse_name,npwp, nik, nip,is_verified_hc,is_verified_email, is_completed, grade_id, email_verification_token) VALUES ('1','2021-12-4', '1', 'Tuti Wulandari','BRI','321205151515','nurul aida','1998-07-17','085318919533','indramayu','ONSITE','NON_ACTIVE','FEMALE', '2021-04-20','indramayu','085323182016','indramayu','45261','ISLAM','jakarta','SINGLE','A',0,'Belum ada','12345678','3212055707980002','14061015900',TRUE,TRUE, TRUE,1,'tokentokentoken');
INSERT INTO employee(id, created_date, id_login, fullname, account_name, account_number, biological_mother_name, date_of_birth,emergency_number, ktp_address, employee_type, employee_status, gender,join_date, npwp_address,phone_number, place_of_birth, postal_code_of_id_card, religion,residence_address, marital_status,blood_type, number_of_children, spouse_name,npwp, nik, nip,is_verified_hc,is_verified_email, is_completed, grade_id, email_verification_token) VALUES ('2','2021-12-4', '2', 'Wisa','BCA','321205151515','nurul aida','1998-07-17','085318919533','indramayu','ONSITE','ACTIVE','MALE', '2021-04-20','indramayu','085323182016','indramayu','45261','ISLAM','jakarta','SINGLE','A',0,'Belum ada','12345678','3212055707980001','14061015902',TRUE,TRUE, TRUE,2,'tokentokentoken');
INSERT INTO employee(id, created_date, id_login, fullname, account_name, account_number, biological_mother_name, date_of_birth,emergency_number, ktp_address, employee_type, employee_status, gender,join_date, npwp_address,phone_number, place_of_birth, postal_code_of_id_card, religion,residence_address, marital_status,blood_type, number_of_children, spouse_name,npwp, nik, nip,is_verified_hc,is_verified_email, is_completed, grade_id, email_verification_token) VALUES ('3','2021-12-4', '3', 'Irfam','BNI','321205151515','nurul aida','1998-07-17','085318919533','indramayu','ONSITE','ACTIVE','MALE', '2021-04-20','indramayu','085323182016','indramayu','45261','ISLAM','jakarta','SINGLE','A',0,'Belum ada','12345678','3212055707980002','14061015900',TRUE,FALSE, TRUE,3,'tokentokentoken');
INSERT INTO employee(id, created_date, id_login, fullname, account_name, account_number, biological_mother_name, date_of_birth,emergency_number, ktp_address, employee_type, employee_status, gender,join_date, npwp_address,phone_number, place_of_birth, postal_code_of_id_card, religion,residence_address, marital_status,blood_type, number_of_children, spouse_name,npwp, nik, nip,is_verified_hc,is_verified_email, is_completed, grade_id, email_verification_token) VALUES ('4','2021-12-4', '4', 'Eka','Mandiri','321205151515','nurul aida','1998-07-17','085318919533','indramayu','ONSITE','NON_ACTIVE','FEMALE', '2021-04-20','indramayu','085323182016','indramayu','45261','ISLAM','jakarta','SINGLE','A',0,'Belum ada','12345678','3212055707980002','14061015900',FALSE,TRUE, TRUE,4,'tokentokentoken');


INSERT INTO admin (id,created_date,name,id_login) VALUES ('1','2021-03-10','ikbal','1');
INSERT INTO admin (id,created_date,name,id_login) VALUES ('2','2021-03-11','arifin','2');


INSERT INTO reimbursement (id, created_date, borne_cost, claim_fee, date_of_claim_submission, disbursement_date, status_on_finance, status_on_hc, status_reject, status_success, id_category, id_employee) VALUES ('1', '2020-12-12', 120000, 120000, '2021-1-12', '2021-4-12', b'0', b'1', b'0', b'1', '1', '1');
INSERT INTO reimbursement (id, created_date, borne_cost, claim_fee, date_of_claim_submission, disbursement_date, status_on_finance, status_on_hc, status_reject, status_success, id_category, id_employee) VALUES ('2', '2020-12-12', 120000, 120000, '2021-3-12', '2021-4-12', b'1', b'0', b'0', b'1', '2', '2');
INSERT INTO reimbursement (id, created_date, borne_cost, claim_fee, date_of_claim_submission, disbursement_date, status_on_finance, status_on_hc, status_reject, status_success, id_category, id_employee) VALUES ('3', '2020-12-12', 120000, 120000, '2021-1-12', '2021-4-12', b'1', b'1', b'0', b'1', '3', '3');