CREATE TABLE `t_commodity` (
`t_id`  int(12) NOT NULL ,
`t_title`  varchar(50) NULL ,
`t_price`  decimal(8,2) NULL ,
`t_unit`  varchar(20) NULL ,
`t_order`  varchar(255) NULL ,
`t_type_id`  int(12) NULL ,
PRIMARY KEY (`t_id`)
)
;

