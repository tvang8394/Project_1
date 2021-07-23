PROJECT NAME
Project Description

SPMS, or Story Pitch Management System, is a full-stack web application that allows authors to submit story pitches to a publishing company. The pitch can then be approved or rejected by editors at various levels and in various committees based on genre and story length before the author is able to submit a draft of the story. The authors are able to track the status of their pitches throughout the process.

# Technologies Used
- gson - version 2.8.7
- postgresql - version 42.2.20
- junit - version 4.11
- javax.servlet-api - version 4.0.1
- log4j-core - version 2.14.1

# Features
List of features ready and TODOs for future development

- An author can only have a limited amount of approved stories pending through the company. The number of stories they can be working on at one time depends on the type of story they have; each type has a certain “weight” which can add up to a maximum number of allotted “points.” With a maximum of 100, novels are each worth 50, novellas are 25 points, short stories are worth 20 points, and articles are worth 10 points. If an author tries to submit a pitch for a story for which they do not have sufficient points, the pitch will not be submitted and will instead be “on hold” so that the author can re-submit at a later date when they do have sufficient points.

- An author must include the following information when submitting a story pitch: basic author information, tentative story title, tentative completion date, story type (based on length), genre, tag line, and detailed description. 

- If denied, the assistant will need to provide a reason to the author. If the assistant takes too long to approve the pitch, it should be labelled as “high priority” for the assistant. “High priority” pitches must be accepted or rejected before their other pitches can be reviewed. If the relevant genre committee does not have any assistant editors, this step will be skipped.

- An editor who is NOT in the relevant genre committee must then approve the story pitch. 

- A senior editor from the relevant genre committee will then need to approve the pitch. They can request more information from any of the individuals who have approved the pitch before approving or rejecting it if they would like

- If the senior editor changes any information from the pitch, the author should be notified and have the opportunity to either approve the changes or cancel the pitch. If the senior editor takes too long to approve the pitch, it should be labelled as “high priority” for them and shown at the top of the list of pitches that require approval, but this should not prevent them from reviewing other pitches.




