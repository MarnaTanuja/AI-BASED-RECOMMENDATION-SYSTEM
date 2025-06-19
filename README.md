# AI-BASED-RECOMMENDATION-SYSTEM

*COMPANY* : CODTECH IT SOLUTIONS

*NAME* : MARNATANUJA

*INTERNID* : CT04DN736

*DOMAIN* : JAVA PROGRAMMING

*DURATION* : 4 WEEKS

*MENTOR* : NEELA SANTOSH

This project is a simple, command-line based recommendation system built using Apache Mahout, a scalable machine learning library. The system combines both user-based collaborative filtering and content-based filtering techniques to recommend items to users based on their preferences and item categories. It is designed for educational or prototype purposes to demonstrate how recommender systems can be implemented using Java and Maven.

The project consists of two primary functionalities:

*User-Based Collaborative Filtering Recommendations:*
It recommends items for users based on similar users' preferences using Mahout's built-in recommendation engine.

Content-Based Search by Category or Keyword: It allows users to explore items based on keywords or categories (e.g., "fitness", "sports", "electronics") and view matching items.

This hybrid approach helps cover both cases where user interaction data is available (for collaborative filtering) and when the user wants to browse based on interests (content filtering).

*Components*

data.csv: Contains user-item ratings in the format userID,itemID,rating. This data is used to build collaborative recommendations using Apache Mahout.

item_data.csv: Contains metadata about items in the format itemID,name,category. This file supports category-based filtering for keyword search.

App.java: The main class responsible for generating recommendations using Mahout’s user-based filtering. It loads the data, calculates user similarities, defines a neighborhood, and outputs top item recommendations for a few users.

ItemExplorer.java: A content-based search module that reads item_data.csv, extracts unique categories, and allows users to type a keyword. It then displays all matching items, enabling interactive exploration based on item metadata.

pom.xml: Maven configuration file defining dependencies (e.g., Mahout libraries) and project build configuration. It ensures the project is compiled and executed correctly using Maven commands.

*How to Compile and Run*

Follow these steps to run the application:

Unzip the project and navigate to the project folder:

bash
Copy code
cd path/to/mahout-recommendation
Make sure Maven is installed on your system. You can verify with:

bash
Copy code
mvn -v
Compile the project using Maven:

bash
Copy code
mvn compile
Run the program:

bash
Copy code
mvn exec:java
Follow the prompts:

You will first be shown a list of available item categories.

Type a keyword like fitness, sports, or electronics.

The program will display a list of items in that category.

Then, it will print user-based recommendations for users 1, 2, and 3 based on similarities calculated using the Pearson correlation method.

*Example Output*

yaml
Copy code
Available categories:
 - electronics
 - fitness
 - sports

Enter a category or keyword to search: sports

Items matching 'sports':
  Item ID: 103, Name: Running Shoes, Category: Sports
  Item ID: 104, Name: Football, Category: Sports

Recommendations for user 1:
  Item ID: 106, Score: 4.2
This project demonstrates how Apache Mahout can be used in combination with simple CSV data and Java to build a working recommender system prototype.

##OUTPUT:

![Image](https://github.com/user-attachments/assets/39fd0525-4e87-4c20-81dd-f3201fdafc4a)

