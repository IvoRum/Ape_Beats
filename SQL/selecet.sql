SELECT * from instrument;

/*
    Get all Instruments
*/

SELECT
    it.instrument_type_name,
    i3.name,i3.company,i3.stock,i3.price,i3.manufacturing_date,
       g.name
FROM instrument
join public.item i3 on i3.item_id = instrument.item_id
join public.genre g on g.id = i3.genre
join public.instrument_istrument_type iit on instrument.instrument_id = iit.instrument_id
join public.instrument_type it on it.id = iit.instrument_type_id;

SELECT * from instrument;
/*
    Get all records
*/

SELECT i.name,i.price,i.stock,a.name,rl.name from record
join public.artist a on a.id = record.artist
join public.record_label rl on rl.id = record.record_label
join public.item i on i.item_id = record.item_id;

/*
    Get all artist records
*/
SELECT artist.name from artist
join public.record r on artist.id = r.artist
where name='Queen';

/*
 Most sold item
 */
SELECT count(sale_item.item) as count_,i.name from sale_item
    join public.item i on sale_item.item=i.item_id
group by i.name;



