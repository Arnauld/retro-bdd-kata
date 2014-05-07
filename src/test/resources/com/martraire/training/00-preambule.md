Preamble
========

Retro-discover the existing behavior
------------------------------------

The system currently implements a cancellation policy that we have forgotten.
Please retro-discover the scenarios implemented in the code.

Suggested iterations:

 1. Make group of two or three persons and take time to write down
    scenario that illustrates the behavior of the code
 2. Once several scenario have been written, read them and ask yourselves if
    they sounds "business"
 3. Share your scenario with other groups
 4. ...


Change the behavior
-------------------

On May 5th we want to advertize a brand new policy whereby you can cancel
your order even after your product has been shipped but has not yet been
delivered. For that particular case you need to call the Customer assistance
and ask for a cancellation number.

Propose examples / scenarios to make sure we all understand the new behavior
Implement the new behavior behind a feature toggle with Cucumber-jvm or Specflow
Refactor the code to make it simpler and using the right vocabulary!


{% asciidiag %}

 +----------+                           +------------+
 |          |   1. I want to cancel     |            |
 | Customer |-------------------------->| Customer   |
 | cGRE {o} |         my order          | Assistance |
 +----------+                           | cRED {io}  |
   |  ^   ^                             +------------+
   |  |   |                               |   |
   |  |   |          2. Why?              |   |
   |  |   \-------------=-----------------/   |
   |  |                                       |
   |  |        3. Cancellation Nb             |
   |  \---------------------------------------/
   |
   |
   |    4. IsCancellable?    /-----------\
   \------------------------>|   Order   |
          Cancellation Nb    \-----------/

{% asciidiag %}


Ready ?
