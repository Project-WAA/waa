use waademoproject;

 -- Drop table users;

create table users(
userId int primary key auto_increment,
username varchar(255) not null,
password varchar(255) not null,
userType int not null,
firstName varchar(255) not null,
LastName varchar(255) not null
);

Insert into users(username,password,userType,firstName,LastName) 
select 'waa' as username,md5('waa') as password,1 as userType, 'waa' as firstName ,'waa' as LastName; 
 


-- drop table quiz;
create table waademoproject.quiz(
quizID int primary key auto_increment,
QuizDescription varchar(800),
quizStartDatetime datetime,
quizendDatetime datetime, 
Enteredby varchar(255) 
);  


Insert into quiz(quizDescription,quizStartDatetime,quizendDatetime) 
select 'Quiz-1.2 Ajax Intro',null,null,null; 

-- drop table Courses; 

create table waademoproject.Courses(
CourseID int primary key auto_increment,
CourseDescription varchar(800), 
EnteredBy varchar(255) 
);

Insert into Courses(CourseDescription,EnteredBy) 
select 'Web Application Architecture','adminUser' 
union all select 'software programming','adminUser'  ; 


-- drop table Questions;
create table waademoproject.Questions(
QuestionID int primary key auto_increment,
CourseId int, 
QuestionDescription varchar(800),  
Answer varchar(800),  
Mark int,
EnteredBy varchar(255)  
); 


create table waademoproject.QuizQuestions( 
QuizQuestionsID int primary key auto_increment, 
QuestionID int, 
QuizID int
); 

/*alter table Questions  add foreign key(quizID) REFERENCES  quiz(quizID);

Insert into Questions(quizID,QuestionDescription)
select 1,'what is ur Name' union
select 1,'what is ur address' union
select 1,'what is ur grade' union
select 1,'what is ur class' ;

select * from  Questions;
 */
  
create table waademoproject.AnswerOptions( 
AnswerOptionsId int primary key auto_increment, 
QuestionID int, 
Answer varchar(255), 
isAnswer boolean  
); 

alter table AnswerOptions  add foreign key(QuestionID) REFERENCES  Questions(QuestionID); 

Insert into AnswerOptions(QuestionID,Answer,isAnswer) 
select 1,'vinod',1 union 
select 1,'Abcd',0 union 
select 1,'efgh',0 union 
select 1,'ijkl',0; 


