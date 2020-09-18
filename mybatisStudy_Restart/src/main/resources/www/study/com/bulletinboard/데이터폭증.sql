insert into t_post (hierarchy_id, writer_id, content,  post_type, bb_id, title)
select to62(nextval('seq4reply')) , writer_id, content, post_type, bb_id, title
	from t_post;

	
	