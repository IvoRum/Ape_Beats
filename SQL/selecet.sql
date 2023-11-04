/*
    Get all Instruments
*/

SELECT
    it.instrument_type_name,
    i3.name as item_name,c.name,i3.stock,i3.price,i3.manufacturing_date,
       g.name
FROM instrument
join public.item i3 on i3.item_id = instrument.item_id
join public.genre g on g.id = i3.genre
join public.instrument_istrument_type iit on instrument.instrument_id = iit.instrument_id
join public.instrument_type it on it.id = iit.instrument_type_id
join public.company c on c.id = i3.company;

/*
    Get all records
*/

SELECT i.name as item_name ,i.price,i.stock,a.name as artist_name,rl.name as record_label_name from record
join public.artist a on a.id = record.artist
join public.record_label rl on rl.id = record.record_label
join public.item i on i.item_id = record.item_id;

/*
    Get all artist records
*/
SELECT artist.name as artist_name, rl.name as record_label_name from artist
    join public.record r on artist.id = r.artist
join public.record_label rl on artist.record_label = rl.id;

/*
    Get artist by name
 */
SELECT artist.name as artist_name, rl.name as record_label_name from artist
join public.record r on artist.id = r.artist
join public.record_label rl on artist.record_label = rl.id
where artist.name='Queen'
Limit 1;

/*
 Most sold item
 */
SELECT count(sale_item.item) as count_,i.name from sale_item
    join public.item i on sale_item.item=i.item_id
group by i.name
order by count_ desc
LIMIT 1
;

select id from artist
order by id desc
LIMIT 1;


select Instrument_id from instrument
order by Instrument_id desc
LIMIT 1;

select item_id from Item
order by item_id desc
LIMIT 1;

select Record_id from Record
order by Record_id desc
LIMIT 1;

select id from Sale
order by id desc
LIMIT 1;

select * from Instrument;
select * from Item;
select * from Record;


UPDATE Item set name='balaklava' where item_id=15;
UPDATE Item set name='balaklava' where item_id=15;
