create TABLE user_program_assignment (
  id UUID NOT NULL,
   account_id VARCHAR(255),
   user_id VARCHAR(255),
   status VARCHAR(255),
   progress INTEGER,
   average_score INTEGER,
   due_date TIMESTAMP with time zone,
   program_id UUID,
   creation_date TIMESTAMP with time zone,
   update_date TIMESTAMP with time zone,
   CONSTRAINT pk_user_program_assignment PRIMARY KEY (id)
);

alter table user_program_assignment add CONSTRAINT FK_USER_PROGRAM_ASSIGNMENT_ON_PROGRAM FOREIGN KEY (program_id) REFERENCES program (id);