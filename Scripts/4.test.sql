select * from title;
select * from department;
select EMP_NO, EMP_NAME, TITLE, MANAGER, SALARY, DNO, HIREDATE from employee;

select EMP_NO, EMP_NAME, TITLE, MANAGER, SALARY, DNO, HIREDATE
from employee
where EMP_NO=4377;

insert into EMPLOYEE values(1, '박영권', 3, 4377, 3000000, 1,'2020-08-25');

update EMPLOYEE
set EMP_NAME = ?, TITLE = ?, MANAGER = ?, SALARY = ?,DNO=?,HIREDATE=?
where EMP_NO =?;

delete from EMPLOYEE where EMP_NO = ?;


