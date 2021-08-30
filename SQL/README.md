# SQL Challenge

Each solution must be a single sql query statement. The data used to test your queries may be different than the data you are given. The schema will be the same. All table names should be lower cased.

## Schema

![Database Schema](DatabaseSchema.png)

## Query 1

Return the zoom_id, last_name and first_name, of all users with a last name of Stradling.   The results should be in zoom_id order ascending.

Answer:

```sql
SELECT zoom_id, last_name, first_name FROM zoom_user
WHERE last_name = 'Stradling'
ORDER BY zoom_id ASC;
```

## Query 2

Return all meeting_id, meeting_name, and start date for all meetings that have the word mobile in the meeting name.  It should be returned by meeting_id ascending.

Answer:

```sql
SELECT meeting_id, meeting_name, start_date FROM meeting
WHERE meeting_name LIKE '%mobile%'
ORDER BY meeting_id ASC;
```

## Query 3

Return the meeting_name, and last_name of the host for the meeting that has a passcode of 939904.

Answer:

```sql
SELECT meeting_name, last_name FROM meeting
JOIN zoom_user ON meeting.host_id = zoom_user.zoom_id
WHERE passcode = 939904;
```

## Query 4

Return meeting_id, meeting_name, and count of how many users are attending the meeting.  It should be ordered by the # of people attending the meeting then by meeting id.

Answer:

```sql
SELECT meeting.meeting_id, meeting_name, COUNT(meeting.meeting_id) FROM meeting
JOIN user_meeting ON meeting.meeting_id=user_meeting.meeting_id
GROUP BY meeting.meeting_id
ORDER BY COUNT(meeting.meeting_id),meeting_id ASC;
```

## Query 5

Return back the query above, but only for meetings that have 13 or more attendees.

Answer:

```sql
SELECT meeting.meeting_id, meeting_name, COUNT(meeting.meeting_id) FROM meeting
JOIN user_meeting ON meeting.meeting_id=user_meeting.meeting_id
GROUP BY meeting.meeting_id HAVING COUNT(meeting.meeting_id)>=13
ORDER BY COUNT(meeting.meeting_id), meeting_id ASC;
```

## Query 6

Return zoom_id, email address ordered by zoom_id of all users who have not hosted a meeting or attended a meeting.

Answer:

```sql
SELECT zoom_id, email FROM zoom_user
LEFT JOIN user_meeting ON zoom_id = zoom_user_id
LEFT JOIN meeting ON zoom_id = host_id
WHERE user_meeting.meeting_id IS NULL AND host_id IS NULL
ORDER BY zoom_id ASC;
```

## Query 7

Return the meeting_id, meeting_name, passcode ordered by meeting_id of all meetings that are categorized as both Research and Education.

Answer:

```sql
SELECT meeting.meeting_id, meeting_name, passcode FROM meeting
JOIN meeting_category ON meeting.meeting_id = meeting_category.meeting_id
JOIN category ON meeting_category.category_id = category.category_id
WHERE category_name = 'Research' OR category_name = 'Education'
GROUP BY meeting_id HAVING COUNT(*)>=2;
```

## Query 8

Return the last name, email, meeting_name and ipv4address ordered by email of all people who have attended a meeting that was catagorized as a Conference and the ipv4address starts with 159.

Answer:

```sql
SELECT last_name, email, meeting_name, ipv4address FROM zoom_user
JOIN user_meeting ON zoom_id = zoom_user_id
JOIN meeting ON meeting.meeting_id = user_meeting.meeting_id
JOIN meeting_category ON meeting.meeting_id = meeting_category.meeting_id
JOIN category ON meeting_category.category_id = category.category_id
WHERE category_name = 'Conference' AND ipv4address LIKE '159.%' ORDER BY email;
```

## Query 9

Return the meeting_name, meeting_id and passcode for all meetings that have a null for the passcode.  Order the results by meeting_name descending. 

Answer:

```sql
SELECT meeting_name, meeting_id, passcode FROM meeting
WHERE passcode IS NULL
ORDER BY meeting_name DESC;
```

## Query 10

Return the last_name, email, role for all users that either attended or hosted the meeting named ‘Ameliorated responsive encoding’ .  Order the results by Role desc then email ascending.

Answer:

```sql
SELECT last_name, email, 'Attendee' AS role FROM zoom_user
JOIN user_meeting ON zoom_id = zoom_user_id
JOIN meeting ON user_meeting.meeting_id = meeting.meeting_id
WHERE meeting_name = 'Ameliorated responsive encoding'

UNION

SELECT last_name, email, 'Host' AS role FROM zoom_user
JOIN meeting ON zoom_id = host_id
WHERE meeting_name = 'Ameliorated responsive encoding'

ORDER BY role DESC, email ASC;
```

## Query 11

Return the first_name, last_name, and meeting for all users has an email address for endgadget.com.  The meeting should be any meeting they’ve hosted, if they’ve never hosted a meeting it should be null.

Answer:

```sql
SELECT first_name, last_name, meeting_name FROM zoom_user
LEFT JOIN meeting ON zoom_id = host_id
WHERE email LIKE '%engadget.com';
```
