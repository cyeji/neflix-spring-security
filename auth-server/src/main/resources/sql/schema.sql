-- 2. users 테이블 생성
CREATE TABLE IF NOT EXISTS `users` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(45) NOT NULL,
    `password` TEXT NOT NULL,
    PRIMARY KEY (`id`)
);

-- 3. otp 테이블 생성
CREATE TABLE IF NOT EXISTS `otp` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(45) NOT NULL,
    `otp_code` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);