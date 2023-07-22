# webAPP_HouseholdAccounts

"webAPP_HouseholdAccounts" is web application that can manage household economy.

※In process

# DEMO

### ---- expense list page ----
<img width="928" alt="image" src="https://github.com/showayamada/webAPP_HouseholdAccounts/assets/108875785/f64d8416-aa99-4a7d-95fb-119563fc2d80">

### ---- expense detail page ----
<img width="933" alt="image" src="https://github.com/showayamada/webAPP_HouseholdAccounts/assets/108875785/d1da9408-6ef5-43c8-ba9e-c72f00e6e384">

### ---- expense register page ----
<img width="581" alt="image" src="https://github.com/showayamada/webAPP_HouseholdAccounts/assets/108875785/442cf5bb-c2ef-4f83-ade2-c7356d90f345">


# Description

This application include the following main features : 

* __Recording of Expenses:__

Users can record detailed information about their expneses, includeing the amount, gategory, and data.

* __Register of Expense by photo:__

User can upload "png" files. An integer obtained from the image by the Amazon Rekognition "Detecting text" is stored in the database as a price.

※Using [EC2_Multifunctional_API](https://github.com/showayamada/EC2_Multifunctional_API)


#### Detail

java 17

spring framework boot 3.1.1

java presistence api 3.1.0

lombok 1.18.20

h2 database

# Requirement

Environments under IntelliJ IDEA is tested.

# Future Update

I want to add some fanctionalities.

* __Aggregation and Analysis by Categories :__

Expenses can be aggregated and analyzed based on different categories, and presented in graphs and tables.

        

* __Multi-User Support :__

The system supports multiple users, allowing each user to create their own accounts and manage their household finaces independently.


* __Improve Function of Register of Expense by photo :__

Function of Register of expense by photo improve by using Google Vision API.

* __Auto Categrize :__

I want to add a [categorizeAI](https://github.com/showayamada/CategorizeAI) "Category Classfier" function to the EC2_Multifunctional_API and use that API.



