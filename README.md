# CalPal
Java based calendar used to store events and plan. This was made for fun and an attempt to make something that was functionable for me to actually use.
This program creates instances of months and displays a dynamic graphic of the month with the events made out of text.

To use program run it in the terminal. Enter the following when it prompts for a username

Username: guest


Or to view an example enter this

Username: KingsOfLiam

Password: Use_somebody123

# Save File
The name of the txt file in the same folder as the program serves as the Username of an "account". The first line should be the password. In the case of the guest, it has no save, therefore no txt file and is caught within the code of CalPal.java.  
  
`Use_somebody123
MONTH:June:1:30
EVENT:11:Last day of school
EVENT:19:Leave for Europe Trip 2026
EVENT:23:Arrive at Grandmas
EVENT:25:SAT Prep
EVENT:26:Leave for Scotland
RECURRING:7:4:Church
RECURRING:2:3:Football Practice
MONTH:July:6:31
EVENT:2:Wild Camping at Glen Coe
EVENT:11:Frisbee in park
EVENT:25:Visit cousins
RECURRING:12:2:Church`
  
All of the following is written automatically to the txt file upon saving and quiting.  
  
##Month
Note every "account" must have a starting month. Right under the password should be `"MONTH:A:B:C"`
The A above will dictate the name of the month shown on the top of the table.
Here, B should be the date of the first monday, so that the program can aline the days to make it go through monday to sunday.
Lastly C should be the length of the month.  

After the `"MONTH:A:B:C"` is all of the contents of the month each on its own line. When the month is concluded, the `"MONTH:A:B:C"` is simply written again and all consequent lines will attribute to the new month.  
  
##Event  


`Use_somebody123
MONTH:June:1:30
EVENT:11:Last day of school
EVENT:19:Leave for Europe Trip 2026
EVENT:23:Arrive at Grandmas
EVENT:25:SAT Prep
EVENT:26:Leave for Scotland
RECURRING:7:4:Church
RECURRING:2:3:Football Practice
MONTH:July:6:31
EVENT:2:Wild Camping at Glen Coe
EVENT:11:Frisbee in park
EVENT:25:Visit cousins
RECURRING:12:2:Church`

