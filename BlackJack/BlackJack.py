#!  /usr/bin/env python3
import random
import Player

'''
def dealCards():
    J = 10
    Q = 10
    K = 10
    A = 11
    Deck = [A,A,A,A,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,
            7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,J,J,J,J,Q,Q,Q,Q,K,K,K,K]

    player = Player.Player()
    Dealer = Player.Player()
    for _ in range(1):
        i = random.randint(0, len(Deck)-1)
        player.hand.append(Deck[i])
        Deck.remove(i)
        i = random.randint(0, len(Deck) - 1)
        Dealer.hand.append(Deck[i])
        Deck.remove(i)
'''

def main():
    print("BlackJack")
    buyIn = input("Enter buy in: ")
    while buyIn != None and buyIn > 0:
        J = 10
        Q = 10
        K = 10
        A = 11
        Deck = [A,A,A,A,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,
                7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,J,J,J,J,Q,Q,Q,Q,K,K,K,K]

        player = Player.Player()
        dealer = Player.Player()
        for _ in range(1):
            i = random.randint(0, len(Deck)-1)
            player.hand.append(Deck[i])
            Deck.pop(i)
            i = random.randint(0, len(Deck) - 1)
            dealer.hand.append(Deck[i])
            Deck.pop(i)

        print("Dealer's hand : ")
        print(dealer.hand)
        print("\n")
        print("Your hand: ")
        print(player.hand)
        print("\n")

        while player.choice == True:
            choice = input("Hit or Stay")
            if choice.strip().lower() == "hit":
                i = random.randint(0, len(Deck) - 1)
                player.hand.append(Deck[i])
                Deck.pop(i)
                print("Your hand: ")
                print(player.hand)
                print("\n")
                if sum(player.hand) > 21:
                    if(player.hand.contains(A)):
                        A = 1
                    print("Bust")
                    player.choice = False
                if sum(player.hand) == 21:
                    print("You Win!!!")
            if choice.strip().lower() == "stay":
                player.choice = False


        while dealer.choice == True and sum(player.hand) < 21:
            if sum(dealer.hand) < 17:
                i = random.randint(0, len(Deck) - 1)
                dealer.hand.append(Deck[i])
                Deck.pop(i)
            else:
                dealer.choice = False
                print("Dealer's hand : ")
                print(dealer.hand)
                print("\n")

        buyIn = input("Buy in to hand:  ")




if __name__ == '__main__':
    main()