"""
Check sequence of brackets is balanced.
INPUT: Test Cases t; next t lines is a string of brackets.
OUTPUT: 'balanced' if balanced else 'not balanced'
APPROACH: exception handling with operations on stack
"""

test_cases = int(input())

for test in range(test_cases):
    brackets = input()
    bracket_stack = list()
    j = 0
    for bracket in brackets:
        if bracket in ['{', '(', '[']:
            bracket_stack.append(bracket)
        else:
            try:
                x = bracket_stack.pop()
                if bracket is ']' and x is not '[':
                    raise Exception()
                if bracket is '}' and x is not '{':
                    raise Exception()
                if bracket is ')' and x is not '(':
                    raise Exception()
            except:
                j = 1
    if len(bracket_stack) is not 0:
        j = 1
    if j is 0:
        print("balanced")
    else:
        print("not balanced")
