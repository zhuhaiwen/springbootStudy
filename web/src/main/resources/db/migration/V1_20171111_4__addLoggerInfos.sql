CREATE TABLE `t_logger_infos` (
`id`  int(12) NOT NULL ,
`client_ip`  varchar(30) NULL ,
`uri`  varchar(100) NULL ,
`type`  varchar(50) NULL ,
`method`  varchar(10) NULL ,
`param_data`  longtext NULL ,
`session_id`  varchar(100) NULL ,
`time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
`return_time`  varchar(50) NULL ,
`return_data`  longtext NULL ,
`http_status_code`  varchar(10) NULL ,
`time_consuming`  int NULL ,
PRIMARY KEY (`id`)
)
;

