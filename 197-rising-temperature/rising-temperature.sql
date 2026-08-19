# Write your MySQL query statement below
SELECT w.id
FROM Weather w
JOIN Weather v
ON DATEDIFF(w.recordDate,v.recordDate) = 1
Where w.temperature > v.temperature;
