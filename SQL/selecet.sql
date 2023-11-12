/*
    Get all Instruments
*/

SELECT
    it.instrument_type_name,
    i3.name as item_name,c.name,i3.stock,i3.price,i3.manufacturing_date, i3.discrimination
    ,g.name as gener_name
FROM instrument
join public.item i3 on i3.item_id = instrument.item_id
join public.genre g on g.id = i3.genre
join public.instrument_istrument_type iit on instrument.instrument_id = iit.instrument_id
join public.instrument_type it on it.id = iit.instrument_type_id
join public.company c on c.id = i3.company;

insert into instrument_istrument_type(instrument_id, instrument_type_id)
VALUES(10,1);

select * from genre;
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
    todo
    sell item
        1-add to sale_item
        2-add to sale
        3-finish
    see all sales and user to dem
    WEB
    add drop down to admin meny
    add id to the tables & order them by id
    add user profile

*/
/*
    All sales for a user
*/
SELECT sale.number, au.email from sale
join public.ape_user au on au.id = sale.ape_user
where au.id=4
group by au.email, sale.number;

SELECT sale.number , sale.amount, sale.time_stamp, sale.fulfill from sale
join public.ape_user au on au.id = sale.ape_user
where au.id=4
group by au.email, sale.number;
/*
    Update user status
*/
    update client set status=2 where ape_user=1;
/*
 Most sold item
 */
SELECT count(sale_item.item) as count_,i.name, i.discrimination as img_url from sale_item
    join public.item i on sale_item.item=i.item_id
group by i.name, i.discrimination
order by count_ desc
LIMIT 1;
/*
    Sale a item
*/
/* Step 0: get users curent shoping cart if he hsae one*/

    SELECT client.status from client
        where client_id =1;

/* Step 1: make a Sale and add a item*/

insert into sale(number, ape_user, amount, fulfill, time_stamp)
values (11,2,0,false, CURRENT_DATE);

/* Stem 2: Persist clients shopping cart id as sale.number
   and add new items as the clients adds them to the cart
   where 1 is the new item
   where 11 is the users shopping cart*/
insert into sale_item(sale, item)
values (11,1);
/*delete item from shopping cart*/
delete from Sale_item where sale_item.sale=? && sale_item.item=?;
/* Step 3: Finish the order and set to user*/
update sale set fulfill=true where number=?;

/*
    Get by Instrument Type
*/
/* Select all instrument types for drop down*/
SELECT instrument_type_name from instrument_type;

SELECT
    it.instrument_type_name,
    i3.name as item_name,c.name,i3.stock,i3.price,i3.manufacturing_date, i3.discrimination
        ,g.name as gener_name
FROM instrument
         join public.item i3 on i3.item_id = instrument.item_id
         join public.genre g on g.id = i3.genre
         join public.instrument_istrument_type iit on instrument.instrument_id = iit.instrument_id
         join public.instrument_type it on it.id = iit.instrument_type_id
         join public.company c on c.id = i3.company
WHERE it.id=3;


/*
    Get by Records Genre
*/
/* Select all genres for drop down*/
SELECT name from genre;

SELECT i.name as item_name ,i.price,i.stock,
       a.name as artist_name,rl.name as record_label_name from record
           join public.artist a on a.id = record.artist
           join public.record_label rl on rl.id = record.record_label
           join public.item i on i.item_id = record.item_id
where i.genre=2;
/*
    See all used sales
*/
select sale.amount,sale.time_stamp as date,au.email as user from sale
join public.ape_user au on au.id = sale.ape_user
join public.client c on au.id = c.ape_user
where sale.fulfill=true;

/*
    Drop down selects
*/

select artist.name from artist;
select company.name from company;
SELECT name from genre;
SELECT instrument_type_name from instrument_type;
select rl."name"  from record_label rl;
/* All record names*/
select i."name"  from record r
join public.item i on i.item_id = r.item_id ;
/* All instrument names*/
select i."name"  from instrument i2 
join public.item i on i.item_id = i2.item_id ;

/*
    user profile
*/

SELECT * from ape_user
join public.client cl on cl.ape_user=ape_user.id
where ape_user.id=4;