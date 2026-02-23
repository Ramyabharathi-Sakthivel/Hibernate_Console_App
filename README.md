🍲 Hibernate Console App – Food Donation Coordination System

A Java console-based application built using Hibernate ORM and Oracle Database to manage and coordinate local food donations efficiently.

📌 Project Overview

This project simulates a food donation coordination system where:

Donors can register food donations

Volunteers can be assigned to pick up donations

Trips are created for transporting food to NGOs or shelters

Donation and trip details are stored using Hibernate ORM

The application follows a DAO-based architecture and interacts with an Oracle database using Hibernate 6.

🛠 Technologies Used

Java (JDK 17 recommended)

Hibernate ORM 6.4

Oracle Database

Maven (if applicable)

Git & GitHub

📂 Project Structure

Hibernate_Console_App

com.foodrelief.bean

Donation.java

Trip.java

com.foodrelief.dao

DonationDAO.java

TripDAO.java

com.foodrelief.util

HibernateUtil.java

com.foodrelief.app

FoodReliefMain.java

hibernate.cfg.xml

⚙️ Features

✔ Register new food donations

✔ Create trips for donations

✔ Assign volunteers

✔ Store records in Oracle Database

✔ Automatic schema update using Hibernate

✔ Clean console output

🗄 Database Configuration

Update your hibernate.cfg.xml with your Oracle credentials:

hibernate.connection.url = jdbc:oracle:thin:@localhost:1521:xe

hibernate.connection.username = your_username

hibernate.connection.password = your_password

▶️ How to Run

Clone the repository
git clone https://github.com/your-username/Hibernate_Console_App.git

Open the project in Eclipse or IntelliJ

Configure Oracle Database

Run FoodReliefMain.java

🧪 Sample Output
--- Local Food Donation Coordination Console ---
DONATION REGISTERED
TRIP CREATED
