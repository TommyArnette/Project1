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
