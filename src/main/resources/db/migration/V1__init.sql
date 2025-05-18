CREATE TABLE t_orders(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  order_number varchar(200) DEFAULT NULL,
  sku_code varchar(200),
  price decimal(16, 2),
  quantity int(11),
  version int(11),
  PRIMARY KEY (id)
  );