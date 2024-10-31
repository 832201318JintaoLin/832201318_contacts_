# Introduction

This file aims to explain the purpose of each file. 

# Back End

## src

### 	**Resource**

#### 		**application.yml**

 Used to connect the back-end Java files to the MySQL database (defines the port and inputs the database username and password).

### 	**entity**

#### 		User.java

 Create a User entity that matches all the properties in the database. The User entity serves as an instantiation of the table in the MySQL database.

### 	**Mapper**

#####  		**UserMapper.java**

 The UserMapper interface defines a Mapper layer related to the User entity, specifying the operations to perform on the database. This project imports MyBatis-Plus's BaseMapper, allowing the UserMapper interface to inherit from it. Through the UserMapper interface, you can directly call methods provided by MyBatis-Plus without manually writing SQL statements.

##### 		**UserMapper.xml**

 This is an XML mapping file for MyBatis, typically used to configure SQL statements and mapping relationships. Specifically, it maps the operations defined in UserMapper to SQL statements. However, in this project, the UserMapper interface uses methods from BaseMapper for User operations, so there are no specific SQL statements.

### 	**Service**

#### 		 **UserService**

 The UserService interface defines business logic methods related to the User entity. In this project, UserService extends the IService interface, allowing it to directly use the basic CRUD operations provided by MyBatis-Plus.

#### 		**impl**

##### 			UserServiceImpl.java

 The UserServiceImpl class is the concrete implementation of the UserService interface. By extending ServiceImpl, it inherits basic CRUD capabilities and is managed by Spring through the @Service annotation, facilitating dependency injection in other components.

### 	**Utils**

####  		**CORSConfig.java**

 The CORSConfig class configures the CORS policy for the Spring Boot application, allowing cross-origin requests. This enables web requests to be received by the local application.

#### 		**MybatisPlusConfig.java**

 The MybatisPlusConfig class configures interceptors for MyBatis-Plus, supporting pagination for MySQL database operations and preventing full table operations. This ensures both the speed and security of database operations in the project.

### 	**Controller**

#### 		 **UserController.java**

 This file contains interfaces to respond to HTTP requests sent from the web front-end and display processing results. The basic interfaces include "add," "delete," "edit," and "list," implementing functionality for adding, deleting, editing, and displaying entries in the phone book.

### 	Launcher

#### 		**PhoneBookApplication.java**

 The PhoneBookApplication class is the entry point for the entire Spring Boot application, responsible for starting the application.

# Front End

There is a 'index.html' document inside this file, the document mainly consists of three parts: HTML, CSS, and JavaScript.

## index.html

### **HTML**

1. Set up the overall framework for the phone book.
2. Created a modal with the ID "modal" for displaying windows after clicking "Edit" and "Add Entry."
    Overall, the HTML framework established a structure for displaying  content in the phone book and included "modal" for "Add" and "Edit."

### **CSS**

1. Defined a class "container" for displaying the overall phone book framework and applied styles to it.
2. Formatted the overall HTML framework.
3. Styled the table used to display phone book content to match the container.
4. Styled buttons including "Add," "Delete," "Edit," "Submit," and "Close." These are the functional buttons for the web interface.
5. Styled the input fields.
    Overall, the CSS beautified the entire page and text display. Different styles for the functional buttons enhance distinction and improve aesthetics.

### **JavaScript** 

Functions were set up here to provide interactive effects on the page and to handle HTTP requests for back-end interaction.

The following part is some explanations of the function inside JavaScript

1. **function showModal(mode, id)**
    This function displays the modal to support adding and editing entries. It determines whether the mode is "add" or "update" to set the behavior of the submit button, and prepares the appropriate input fields in "edit" mode.
2. **window.onclick = function(event)**
    This function monitors events to detect whether the mouse clicks outside the modal (the pop-up for creating a new contact). If clicked outside, it closes the modal.
3. **document.querySelector('.close').onclick = function()**
    This function handles the response when the user clicks the close button. It automatically calls this function to close the modal and clear inputs.
4. **function clearInputs()**
    This function is used to clear user inputs.
5. **function addEntry()**
    This function handles the logic for adding entries, including input validation, data submission, successful response handling, and updating the interface.
6. **function loadPhoneBook()**
    This function fetches data from the server and displays it to the user upon successful retrieval.
7. **function displayData(data)**
    This function displays the data in a table format. It first clears the content of the table with the ID 'phoneTbody,' then iterates through the data to create a row for each entry, adding all elements into it. Finally, it adds the row into the table with the ID 'phoneTbody.'
8. **function deleteEntry(id)**
    This function implements the logic for deleting entries, including user confirmation, sending the delete HTTP request, and updating the user interface.
9. **function updateEntry()**
    This function implements input validation for updates, sends the update HTTP request, handles the response, and updates the interface, providing a complete logic for updating the contact list.
