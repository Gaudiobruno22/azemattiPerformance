ALTER TABLE `azematti`.`t_ser_tpservico` 
ADD COLUMN `SER_TPSERVICO_VALOR` FLOAT(6,2) DEFAULT 0.00 AFTER `SER_TPSERVICO_MECANICA`;

UPDATE `azematti`.`t_ser_tpservico` SET `SER_TPSERVICO_VALOR` = '2000.00' WHERE (`SER_TPSERVICO_COD` = '1');
UPDATE `azematti`.`t_ser_tpservico` SET `SER_TPSERVICO_VALOR` = '2900.00' WHERE (`SER_TPSERVICO_COD` = '2');
UPDATE `azematti`.`t_ser_tpservico` SET `SER_TPSERVICO_VALOR` = '6000.00' WHERE (`SER_TPSERVICO_COD` = '3');