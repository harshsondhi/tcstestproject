CREATE TABLE IF NOT EXISTS `payments` (
  `payment_id` BIGINT NOT NULL AUTO_INCREMENT,
  `card_member_id` BIGINT NOT NULL,
  `amount` DECIMAL(10,2) NOT NULL,
  `card_type` varchar(100) NOT NULL,
  `total_limit` int NOT NULL,
  `amount_used` int NOT NULL,
  `available_amount` int NOT NULL,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
);