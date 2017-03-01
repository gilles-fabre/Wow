# Wow
Who owes who

This program aims to solve the "who owes who" problem, where people pay for resources, consume them, lend or borrow money 
from each other, etc. People can also be part of groups (close friends, couples, travelled together, whatever..) or single/alone.

To use the program, just tap 'add' to enter a new action (someone pays for something, consumes something, lends money to someone, 
or borrows from someone else, etc). Then, group people if required by using the 'Add' + "Pertains" action.

Once all the data for the problem has been entered, one can hit the 'Resolve' button and have Wow do the resolution job.

The GUI is pretty simple (although not very intuitive, sorry for that) with a Table view showing the initial problem data, a 
Graphical view displaying the various resources and exchanges across consumers and payers, and lastly the Resolution log view 
reading the problem resolution log (in case someone says, "hey, I payed more than anyone, why should I owe anyone money?" to which
you may reply "cause you've ve got the largest familly dude!" or just show the log).

Of course, data can be saved, loaded, added, removed, modified (by double clicking a table entry), etc. 

There's no constraint on the type of 'value unit' used to pay. Most of the time, money is used to pay, but you may decide to use 
chocolate bars, salt, etc. The only constraint is "*ALL* payments must use the same type of value unit". That is, if Bob pays using
dollars, than everyone must use dollars. The result of the problem resolution will be expressed in the same 'value unit' refunds 
accross people.

In the same manner, there's no constraint on the type of 'consumption unit' used when someone consumes something. It might be 
'glasses' for drinks, 'nights' for a stay in a hotel, 'driven miles' for a rental car usage, '1/8th parts' for a pizza, etc. 
Here again, the only constraint is that the same 'consumption unit' for a thing is used everytime someone consumes that particular 
thing.

The groups may be defined in the end, since entering the first letter of an existing person or group will auto-complete the name. 
I don't think using groups as consumers or payers works, and I don't I even tried to prevent the user from enterign such data,
so this might be the first (and easiest) thing to fix.

In fact, 'Wow' can solve any problem related to resources sharing accross people or group of people, could it be holidays with 
friends or a company's affiliate sites exchanges...

The algorithms (very simple), should be ok, what's really lacking here is a better GUI (I wrote this cause I was fed up with 
doing this by hand when going on two weeks holidays with by group of 28 friends) and a help section.

Have fun with this, do whatever you want with it, use or trash it, it's now yourse :)

