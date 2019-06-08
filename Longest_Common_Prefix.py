"""
AIM: Given an array of Strings, find the longest prefix in the strings.
INPUT: Test Cases, Size of array, All elements of array in a single line.
OUTPUT: Longest prefix, if not none. Else -1.
APPROACH: Using sets. In the end when size of set is left to 1 just print the element by checking it if it is empty or not.
"""

test_cases = int(input())


for test in range(test_cases):
    size = int(input())
    strings = set(input().split())
    min_length = 1001
    for string in strings:
        x = len(string)
        if x < min_length:
            min_length = x
    while(len(strings) > 1):
        small_strings = set()
        for string in strings:
            small_strings.add(string[:x])
        strings = small_strings
        x -= 1
    for string in strings:
        if string is not "":
            print(string)
        else:
            print("-1")
