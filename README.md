# **Expense Reimbursement System**
## Project Description
The Expense Reimbursement System will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used
* Intellij
* DBeaver
* Visual Studio Code
* Amazon AWS / RDS
* TomCat

## Features
* Conditional login routing determined by employee role (Employee or Finance Manager)
* Employees capable of creating and submitting new expense reimbursement requests
* Employees able to view their past reimbursement requests
* Finance managers can view all employee's reimbursement requests
* Finance managers may update (approve or deny) pending reimbursements
* Finance managers able to view reimbursement requests with a filter function (all, pending, approved, denied)

To-do list:
* Allow finance managers functionality to create new employee accounts
* Encrypt & has passwords in the database
* Send email to new employees upon account creation
* Allow employees to upload an image of their receipt when submitting reimbursement request

## Getting Started
* To clone into the project, use: git clone https://github.com/TommyArnette/Project1.git
* Install DBeaver, link your Amazon AWS database
* Install TomCat and configure the Deployment Directory, Context Path, Server Port, and Admin Port (shown below)
![TomCat Project 1 Config](https://github.com/TommyArnette/Project1/blob/main/TomCat_P1_Config.PNG)
* Create a new database in DBeaver
* Create a new SQL script and run the following code:
> ```
> CREATE TABLE ers_reimbursement_status(
	reimb_status_id SERIAL PRIMARY KEY,
	reimb_status varchar(10) NOT NULL
);
CREATE TABLE ers_reimbursement_type(
	reimb_type_id SERIAL PRIMARY KEY,
	reimb_type varchar(10) NOT NULL
);
CREATE TABLE ers_user_roles(
	ers_user_role_id SERIAL PRIMARY KEY,
	user_role varchar(10) NOT NULL
);
CREATE TABLE ers_users(
	ers_users_id SERIAL PRIMARY KEY,
	ers_username varchar(50) UNIQUE NOT NULL,
	ers_password varchar(50) NOT NULL,
	user_first_name varchar(100) NOT NULL,
	user_last_name varchar(100) NOT NULL,
	user_email varchar(150) UNIQUE NOT NULL,
	user_role_id int REFERENCES ers_user_roles(ers_user_role_id) ON UPDATE CASCADE
);
CREATE TABLE ers_reimbursement(
	reimb_id SERIAL PRIMARY KEY,
	reimb_amount int NOT NULL,
	reimb_submitted TIMESTAMP NOT NULL,
	reimb_resolved TIMESTAMP,
	reimb_description varchar(250),
	reimb_receipt bytea,
	reimb_author int REFERENCES ers_users(ers_users_id) NOT NULL ON UPDATE CASCADE,
	reimb_resolver int REFERENCES ers_users(ers_users_id),
	reimb_status_id int REFERENCES ers_reimbursement_status(reimb_status_id) NOT NULL ON UPDATE CASCADE,
	reimb_type_id int REFERENCES ers_reimbursement_type(reimb_type_id) NOT NULL ON UPDATE CASCADE
);```
