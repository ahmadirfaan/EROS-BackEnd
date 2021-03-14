INSERT INTO `reimburse`.`grade` (`id`, `give_birth_cost`, `glasess_cost`, `hotel_cost`, `meal_cost`, `id_grade`, `transportation_cost`) VALUES ('66f196da-8973-40cf-8e17-80b54cfedba7', '100000', '150000', '300000', '200000', '1', '150000');
INSERT INTO `reimburse`.`grade` (`id`, `give_birth_cost`, `glasess_cost`, `hotel_cost`, `meal_cost`, `id_grade`, `transportation_cost`) VALUES ('7a0a4a9b-0374-4fbc-88c0-1fe23e824ece', '200000', '200000', '400000', '300000', '2', '200000');
INSERT INTO `reimburse`.`grade` (`id`, `give_birth_cost`, `glasess_cost`, `hotel_cost`, `meal_cost`, `id_grade`, `transportation_cost`) VALUES ('fb31c00d-89d3-48b2-a5ef-c150d6d7d4b9', '300000', '250000', '500000', '400000', '3', '300000');
INSERT INTO `reimburse`.`grade` (`id`, `give_birth_cost`, `glasess_cost`, `hotel_cost`, `meal_cost`, `id_grade`, `transportation_cost`) VALUES ('d17590e0-9ec4-4fe5-a513-fe533f10fead', '400000', '300000', '600000', '500000', '4', '400000');


INSERT INTO `reimburse`.`category` (`id`, `category_name`) VALUES ('1e4bbbee-83f3-11eb-8dcd-0242ac130003', 'glasses');
INSERT INTO `reimburse`.`category` (`id`, `category_name`) VALUES ('1e4bbbee-83f3-11eb-8dcd-0242ac130004', 'training');
INSERT INTO `reimburse`.`category` (`id`, `category_name`) VALUES ('1e4bbbee-83f3-11eb-8dcd-0242ac130005', 'give_birth');
INSERT INTO `reimburse`.`category` (`id`, `category_name`) VALUES ('71ff287a-83f3-11eb-8dcd-0242ac130003', 'official_travel');
INSERT INTO `reimburse`.`category` (`id`, `category_name`) VALUES ('71ff287a-83f3-11eb-8dcd-0242ac130098', 'insurance');



INSERT INTO role(id,created_date,role_name) VALUES (1,'2021-03-13','super_admin');
INSERT INTO role(id,created_date,role_name) VALUES (2,'2021-03-14','admin_finance');
INSERT INTO role(id,created_date,role_name) VALUES (3,'2021-03-16','assistance_admin');
INSERT INTO role(id,created_date,role_name) VALUES (4,'2021-03-17','employee');

INSERT INTO `reimburse`.`login` (`id`, `created_date`, `email`, `password`, `id_role`) VALUES ('58b184ed-b256-4762-92cd-0c67206e0548', '2021-12-1', 'wisa@gmail.com', 'wisa', '1');
INSERT INTO `reimburse`.`login` (`id`, `created_date`, `email`, `password`, `id_role`) VALUES ('7b225550-51a9-492c-beea-ce4d807f1eda', '2021-12-2', 'irfan@gmail.com', 'irfan', '2');
INSERT INTO `reimburse`.`login` (`id`, `created_date`, `email`, `password`, `id_role`) VALUES ('6c1d0c8c-4296-4e67-a04b-3c3fdaa158b7', '2021-12-3', 'wulan@gmail.com', 'wulan', '3');
INSERT INTO `reimburse`.`login` (`id`, `created_date`, `email`, `password`, `id_role`) VALUES ('b884462e-83e7-11eb-8dcd-0242ac130003', '2021-12-4', 'eka@gmail.com', 'eka', '4');


INSERT INTO admin (id,created_date,name,id_login) VALUES ('f924cdd8-2d3c-4b35-8f5b-1a0ccc142c0b','2021-03-10','wisa','58b184ed-b256-4762-92cd-0c67206e0548');
INSERT INTO admin (id,created_date,name,id_login) VALUES ('8b2558c0-2d0f-45e2-a063-617a9ab4f6c7','2021-03-11','irfan','7b225550-51a9-492c-beea-ce4d807f1eda');
INSERT INTO admin (id,created_date,name,id_login) VALUES ('02564c68-c872-43ee-a67a-57d91de2b1b1','2021-03-12','wulan','6c1d0c8c-4296-4e67-a04b-3c3fdaa158b7');
INSERT INTO admin (id,created_date,name,id_login) VALUES ('742cb4d1-060b-421d-bbbc-093d8113040e','2021-03-13','eka','b884462e-83e7-11eb-8dcd-0242ac130003');

INSERT INTO reimbursement(id,created_date,date_of_claim_submission,claim_fee,disbursement_date,status_reject,status_on_hc,status_on_finance,status_success,borne_cost,id_category) VALUES ('0996bde7-5fd6-4c5a-815a-7b2405fa8eca','2021-03-14',150000,'2021-02-12',true,false,false,false,0,'1e4bbbee-83f3-11eb-8dcd-0242ac130005');






--
--
-- INSERT INTO bill(id,created_date,modified_date,bill_image,id_reimbursement) VALUES ;
-- INSERT INTO employee_address(employee_id,ktp_address,npwp_address,postal_code_of_id_card,residence_address,id,created_date) VALUES ('3e40301c-83f6-11eb-8dcd-0242ac130003','sby','sby',2881,'sby','7d13605c-83f6-11eb-8dcd-0242ac130003','2021-1-11');
-- INSERT INTO employee(id,created_date,modified_date,account_name,account_number,biological_mother_name,blood_type,date_of_birth,emerency_number,employee_status,employee_type,fullname,gender,grade,husband_name,id_login,is_verified,join_date,marital_status,nik,nip,npwp,number_of_children,phone_number,place_of_birth,religion,wife_name);
-- INSERT INTO reimbursement_glasess(id,create_date,modified_date,borne_costs,id_reimbursement);
-- INSERT INTO reimbursement_training(id,training_end_date,training_start_date,id_employee,id_reimbursement);
-- INSERT INTO reimbursement_travel(id,end_date,start_date,id_reimbursement);
-- INSERT INTO reimbursement_give_birth(id,end_date,start_date,id_reimbursment);
-- INSERT INTO reimbursement_detail_insurance(id,type_of_insurance,id_reimbursement);
--
-- INSERT INTO reimbursement_travel(id,end_date,start_date,id_reimbursement);


