## ATM based on Angular 4 as a front-end and Spring Boot as a back-end

### What has been done:
- Created H2 database and all necessary objects in it for the application.
- Added a small amount of test data to this database.
- Prepared back-end (Spring Boot) for further business logic, implemented Spring Security with JWT token and Exception Handler;
- Prepared front-end (Angular 4) for further design works. Implemented Routing with separation to Public/Private sections, login/logout and wrappers for http services for further comfortable work;

-----------------------------------------------

### Specifications

#### ATM operation:
• ATM Login Page is a home page for non-authorized user. It prompts user to enter card number and PIN code. Once the user inputs the card number and PIN code and clicks the OK button, a request is sent to the database. Entered PIN is compared with the PIN stored in the DB. If the codes match, the “Operations” page loads. Otherwise, an error message is shown. 
• A user can enter the wrong PIN code not more than 4 times. After the fourth time a message is sent telling the user their card is blocked, and a request is sent to block the card. (in progress) 
• Depending on what operation user selects, either the “Balance”, “Withdrawal” or “Transactions History” page loads.
• User transactions (e.g. withdrawal, balance) are being stored in database with ID, time, and transaction category.
• If the user chooses "Withdrawal” he can enter the amount of money they would like to withdrawal and click “OK.” The system should check and make sure the amount entered does not exceed the account balance. If it does, an error message should be displayed. Also system should check if the requested amount could be processed with available denominations (100, 50, 20). If everything is OK – entry is added to Transactions table with the ID, transaction category, time and amount withdrawn. The table card changes the amount in the account, and then loads a report on the results of the operation including used denominations for performed transactions. (business logic not fully implemented yet)

#### ATM Interface (a lot of work undone here):
• “Login” page. There is a field for card number, buttons with the integers 0-9, "OK" and "Clear" buttons. The user is prompted to enter 16-digit card number. The only possible way to enter is to click on the numbered buttons. In the display, the numbers are divided into groups of 4, for example, the number "1111111111111111" will be displayed as "1111-1111-1111-1111". (in progress) Pressing the "Clear" button will reset the entered numbers. The procedure for PIN code is similar to entering the card number, except that the output is displayed in the field with characters like "*". Pressing the "Clear" button resets the entered numbers.
• “Operations” page. There are 4 buttons on this page: “Balance”, “Withdraw”, “Transactions”, “Exit”. (buttons are displayed in header now)
• “Balance” page. This page provides information about the card-holder’s account, including today’s date, the amount in the account, and two buttons - "Back" and "Exit".
• “Withdrawal” page contains a field for entering numbers, a numeric keypad, and the buttons: "Withdraw" and "Exit".
• “Transactions” page contains information about the card number, date / time, the amount withdrawn, account balances, as well as the buttons "Back" and "Exit".
• Error message. This contains text and a "Back" button.

--------------------------------
Angular default Readme:

#### Frontend

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.3.0.

#### Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

#### Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

#### Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

#### Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

#### Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).
Before running the tests make sure you are serving the app via `ng serve`.

#### Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
