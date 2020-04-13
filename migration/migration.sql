SELECT * FROM (
(SELECT CONCAT("[",GROUP_CONCAT(
	CONCAT("{\"id\":\"",productid,"\","),
	CONCAT("\"type\":\"genomic\","),
	CONCAT("\"description\":\"",productdescription,"\","),
	CONCAT("\"quantity\":",productquantity,","),
	CONCAT("\"price\":",productprice,"}")
	)) FROM genomics AS genom)
UNION ALL
(SELECT CONCAT(",", GROUP_CONCAT(
	CONCAT("{\"id\":\"",productid,"\","),
	CONCAT("\"type\":\"processing\","),
	CONCAT("\"description\":\"",productdescription,"\","),
	CONCAT("\"quantity\":",productquantity,","),
	CONCAT("\"price\":",productprice,"}")
	)) FROM processing AS proces)
UNION ALL
(SELECT CONCAT(",", GROUP_CONCAT(
	CONCAT("{\"id\":\"",productid,"\","),
	CONCAT("\"type\":\"referencematerial\","),
	CONCAT("\"description\":\"",productdescription,"\","),
	CONCAT("\"quantity\":",productquantity,","),
	CONCAT("\"price\":",productprice,"}")
	)) FROM referencematerials AS refer)
UNION ALL
(SELECT CONCAT(",", GROUP_CONCAT(
	CONCAT("{\"id\":\"",productid,"\","),
	CONCAT("\"type\":\"culturebox\","),
	CONCAT("\"description\":\"",productdescription,"\","),
	CONCAT("\"quantity\":",productquantity,","),
	CONCAT("\"price\":",productprice,"}")
	)) FROM cultureboxes AS refer)
UNION ALL
(SELECT CONCAT(",", GROUP_CONCAT(
	CONCAT("{\"id\":\"",product_code,"\","),
	CONCAT("\"type\":\"seed\","),
	CONCAT("\"description\":\"",description,"\","),
	CONCAT("\"quantity\":",quantity,","),
	CONCAT("\"price\":",price,"}")
	)) FROM seeds AS seed)
UNION ALL
(SELECT CONCAT(",", GROUP_CONCAT(
	CONCAT("{\"id\":\"",product_code,"\","),
	CONCAT("\"type\":\"shrub\","),
	CONCAT("\"description\":\"",description,"\","),
	CONCAT("\"quantity\":",quantity,","),
	CONCAT("\"price\":",price,"}")
	)) FROM shrubs AS shrub)
UNION ALL
(SELECT CONCAT(",", GROUP_CONCAT(
	CONCAT("{\"id\":\"",product_code,"\","),
	CONCAT("\"type\":\"tree\","),
	CONCAT("\"description\":\"",description,"\","),
	CONCAT("\"quantity\":",quantity,","),
	CONCAT("\"price\":",price,"}")
	),"]") FROM trees AS tree)
) AS products
INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.6/Uploads/products.json';

SELECT CONCAT("[", GROUP_CONCAT(
	CONCAT("{\"id\":",order_id,","),
	CONCAT("\"date\":\"",order_date,"\","),
	CONCAT("\"firstname\":\"",first_name,"\","),
	CONCAT("\"lastname\":\"",last_name,"\","),
	CONCAT("\"address\":",address,","),
	CONCAT("\"phone\":",phone,","),
	CONCAT("\"total\":",total_cost,","),
	CONCAT("\"shipped\":",shipped,","),
	CONCAT("\"ordertable\":\"",ordertable,"\"}")
	),"]") FROM orders AS orders 
INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.6/Uploads/orders.json';
	
