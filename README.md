# cardGame_dataStructure
Game Strategy

READ ME!

Short write-up describing the strategy that you used for bidding and deciding whether to play or not.
-----------------------------------------------------------------------------------------------------
Ritesh Thapa - 04/20/2018

||Strategy for bidding||
>> If there is joker card in hand, add bid by 1 (i.e: JOKER == 100% chance to win 1 bid) otherwise add bid with winning probability 
of 70%, 50%, 30% ...for Ace, King, Queen and likewise.
_______________________________________________________________________________________________________

||Strategy for deciding whether to play or not||
>> if bid is greater than 0, then chooses to play anyhow.
>> if bid is 0 or is passed but if there is maximum number of trump cards in hand, player chooses to play.
>> if bid is 0 and trump cards are less than others, then player chooses not to play.

***END***
