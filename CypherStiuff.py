import random
import string 

chars = string.punctuation + string.ascii_letters + string.digits + " "

chars = list(chars)
print(chars)

key = chars.copy()
random.shuffle(key)

# Encryption phase


plain_text = input("Enter a message you want to encrypt: ")

cipher_text = ""

for letter in plain_text:
    #index_of_letter = plain_text.index(letter)
    index_of_letter_chars = chars.index(letter)
    encrypted_letter = key[index_of_letter_chars]
    cipher_text += encrypted_letter

print(cipher_text)


# Decryption

cypher_text = input("Enter a message you want to decrypt: ")

plain_text = ""

for letter in cypher_text:
    index_of_cypherletter = key.index(letter)
    decrypted_letter = chars[index_of_cypherletter]
    plain_text += decrypted_letter

print(plain_text)