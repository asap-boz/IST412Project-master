To start the application:

1. Open application.properties file.
2. Enter database connection information.
3. Run the application.
4. Open a browser and navigate enter: http://localhost:8080/

REFACTORING:
Summary of task 1:

1. Original Issue
There was no way to tell which application was submitted by which user.
2. How we resolved this
    1. Updated models to represent relationships between tables (UserInfoModel, LoanApplicationModel)
    2. Implemented classes to getUserID in ApplyController
    3. Injected the UserID to the ApplyController
    4. Updated the CreateLoanApplication method to include UserId in LoanApplicationServiceImpl
    5. Updated HTML template
3. End Result
Now when the user submits a loan application, their userID is a part of the application.
4. This was implemented by Kyle

Summary of task 2:
1. Original Issue
Our navigation to the user dashboard was not working from the apply page.
2. How we resolved this
    1. Injected the userID to the showApplyPage controller.
    2. Updated the HTML apply template to point to the correct location and use the correct ID.
3. End Result
THe navigation was properly linked and the user was able to navigate back to their user dashboard.
4. This was implemented by Kyle

Summary of task 3:
1. Original Issue
Our Code did not implement many comments to explain what was going on.
2. How we resolved this
    1. Implemented comments in the ApplyController, UserInfoModel, UserRepository
3. End Result
The code is much more clear to someone who is not familiar with it.
4. Implemented by Kyle

Summary of task 4:
1. Original Issue
There was no specific location for ATZ Finance employees.
2. How wer resolves this issue
    1. We implemented a new button on our home screen for ATZ Finance employees. They will have a dashboard here.
3. End Result
There is a button for ATZ Finance employees that takes them to a coming soon page
4. Implemented by Kyle

Summary of task 5:
1. Original Issue
Two of the same method
2. How we resolved this
    1. I inspected which method was in use and safe deleted the other one.
3. End Result
There us only one method to create a loan application which leads to less confusion.
4. Implemented by Kyle




