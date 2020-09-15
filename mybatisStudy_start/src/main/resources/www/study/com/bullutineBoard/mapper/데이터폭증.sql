
insert into t_post
select to62(seq4post.nextval), writer_id, content, post_type, bb_id, title
  from t_post;

 