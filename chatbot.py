def greet(bot_name,birth_year):
    print("Hello!My name is {0}.".format(bot_name))
    print("I was created in {0}.".format(birth_year))


def remind_name():
    print("please,remind me your name.")
    name=input()
    print("what a great name you have, {0}!".format(name))

def guess_age():
    print("let me guess your age.")
    print("Enter reminders of dividing your age by 3,5 and 7.")
    
    rem3=int(input())
    rem5=int(input())
    rem7=int(input())
    age=(rem3 * 70 + rem5 * 21 + rem7 * 15) % 105

    print("Your age is {0}; that's good time to start programming.".format(age))

def count():
    print("Now i will prove you that i can count to any number you want.")
    num=int(input())

    counter=0
    while counter<=num:
        print("{0} !".format(counter))
        counter+=1

def test():
    print("Let's test your programming knowlegde.")
    print("Why do we use method?")
    print("1. To repeat a statement multiple times.")
    print("2. To decompose a program into several small subroutines.")
    print("3. To determine execution time of program.")
    print("4. To interrupt execution of program.")

    answer=2
    guess=int(input())
    while guess!=answer:
        print("Please,try again.")
        guess=int(input())

    print("completed,hav a nice day!")
    print(".........................")
    print(".........................")
    print(".........................")

def end():
    print("congratulations,have a nice day!")
    print("................................")
    print("................................")
    print("................................")
    input()





greet('SBot', '2022')
remind_name()
guess_age()
count()
test()
end()