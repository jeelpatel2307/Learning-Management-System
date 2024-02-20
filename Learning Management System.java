class Course:
    def __init__(self, title, instructor, description):
        self.title = title
        self.instructor = instructor
        self.description = description
        self.lectures = []
        self.assignments = []
        self.quizzes = []

    def add_lecture(self, lecture):
        self.lectures.append(lecture)

    def add_assignment(self, assignment):
        self.assignments.append(assignment)

    def add_quiz(self, quiz):
        self.quizzes.append(quiz)


class User:
    def __init__(self, username, email, role):
        self.username = username
        self.email = email
        self.role = role


class Student(User):
    def __init__(self, username, email):
        super().__init__(username, email, "student")
        self.courses_enrolled = []

    def enroll_course(self, course):
        self.courses_enrolled.append(course)


class Instructor(User):
    def __init__(self, username, email):
        super().__init__(username, email, "instructor")

    def create_course(self, title, description):
        return Course(title, self, description)


# Usage example
student1 = Student("student1", "student1@example.com")
instructor1 = Instructor("instructor1", "instructor1@example.com")

course1 = instructor1.create_course("Python Programming", "Learn Python programming basics")
course1.add_lecture("Introduction to Python")
course1.add_assignment("Python Exercise 1")

student1.enroll_course(course1)

print(f"{student1.username} enrolled in {course1.title}")
