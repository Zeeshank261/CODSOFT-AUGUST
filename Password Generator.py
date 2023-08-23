import random
import string

s1 = string.ascii_lowercase
s2 = string.ascii_uppercase
s3 = string.digits
s4 = string.punctuation
plen = int(input("Enter Password length\n"))
s = []
s.extend(s1)
s.extend(s2)
s.extend(s3)
s.extend(s4)
random.shuffle(s)
print("Your Password is: ")
print("".join(s[0:plen]))