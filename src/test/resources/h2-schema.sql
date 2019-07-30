create schema if not exists test;

use test;

CREATE TABLE if not exists `comment`
(
    comment_id int(11) auto_increment,
    content text,
    wtime datetime,
    PRIMARY KEY (comment_id)
);
