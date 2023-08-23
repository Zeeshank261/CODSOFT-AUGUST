import tkinter as tk
import random

def determine_winner(user_choice, computer_choice):
    if user_choice == computer_choice:
        return "It's a tie!"
    elif (user_choice == "rock" and computer_choice == "scissors") or \
         (user_choice == "paper" and computer_choice == "rock") or \
         (user_choice == "scissors" and computer_choice == "paper"):
        return "You win!"
    else:
        return "Computer wins!"

def play_game(user_choice):
    computer_choice = random.choice(["rock", "paper", "scissors"])
    result = determine_winner(user_choice, computer_choice)
    result_label.config(text=f"Computer chose {computer_choice}. {result}")

root = tk.Tk()
root.title("Rock-Paper-Scissors Game")

# Creating the game box
game_box = tk.Canvas(root, width=500, height=500, bg="#f0f0f0")
game_box.pack()

# Styling the buttons
button_style = {
    "padx": 20,
    "pady": 10,
    "font": ("Helvetica", 14, "bold"),
    "bg": "#3498db",
    "fg": "white",
    "activebackground": "#2980b9",
}

rock_button = tk.Button(root, text="Rock", command=lambda: play_game("rock"), **button_style)
paper_button = tk.Button(root, text="Paper", command=lambda: play_game("paper"), **button_style)
scissors_button = tk.Button(root, text="Scissors", command=lambda: play_game("scissors"), **button_style)

# Styling the result label
result_label = tk.Label(root, text="Choose rock, paper, or scissors.", font=("Helvetica", 16, "bold"), bg="#f0f0f0")

# Placing widgets in the game box
rock_button_window = game_box.create_window(100, 400, window=rock_button)
paper_button_window = game_box.create_window(250, 400, window=paper_button)
scissors_button_window = game_box.create_window(400, 400, window=scissors_button)
result_label_window = game_box.create_window(250, 200, window=result_label)

root.mainloop()
