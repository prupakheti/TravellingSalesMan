This program is dynamic programming based solution for TSP problem. The basis for representing a set of cities is an integer itself. An integer represents set of those indices
such that the bit in that index is set to 1. So this program is confined to total number of cities not more than 31. 

There are two ways we can feed input to this program:

1) Feed the adjacency matrix:
	the first line should contain the total number of cities ( say n )
	after that there will be n lines and each line should have n integers value
	
	For eg for 3 x 3 adj matrix  +
				3
			    0 2 2
			    2 0 3 
			    2 3 0


2) Feed the adj List:
	the first line should contain the total number of cities ( say n )
	after this we can have multiple lines with 3 integer values i j and w such that w represents the path cost between cities i and j. the data reader will stop scanning 
	whenever it encounters "end" string in a line.
		For eg for 3 x 3 above adjacency matrix 
		3
		0 1 2
		0 2 2
		1 2 3
		
		
The two modes of input can be selected via command line argument. 
	java TSPDriver <arg1> <arg2>
	
	if arg1 is 1 it selects adj matrix mode of data reader else adj list mode
	arg2 if provided is file from which it reads the data otherwise the default input stream is console
	
	When both the arguments are missing it goes with adj list reader via console. 
	
	Following is a sample input test for adjacency matrix input mode (17 cities ):

17
  0 633 257  91 412 150  80 134 259 505 353 324  70 211 268 246 121
633   0 390 661 227 488 572 530 555 289 282 638 567 466 420 745 518
257 390   0 228 169 112 196 154 372 262 110 437 191  74  53 472 142
 91 661 228   0 383 120  77 105 175 476 324 240  27 182 239 237  84
412 227 169 383   0 267 351 309 338 196  61 421 346 243 199 528 297
150 488 112 120 267   0  63  34 264 360 208 329  83 105 123 364  35
 80 572 196  77 351  63   0  29 232 444 292 297  47 150 207 332  29
134 530 154 105 309  34  29   0 249 402 250 314  68 108 165 349  36
259 555 372 175 338 264 232 249   0 495 352  95 189 326 383 202 236
505 289 262 476 196 360 444 402 495   0 154 578 439 336 240 685 390
353 282 110 324  61 208 292 250 352 154   0 435 287 184 140 542 238
324 638 437 240 421 329 297 314  95 578 435   0 254 391 448 157 301
 70 567 191  27 346  83  47  68 189 439 287 254   0 145 202 289  55
211 466  74 182 243 105 150 108 326 336 184 391 145   0  57 426  96
268 420  53 239 199 123 207 165 383 240 140 448 202  57   0 483 153
246 745 472 237 528 364 332 349 202 685 542 157 289 426 483   0 336
121 518 142  84 297  35  29  36 236 390 238 301  55  96 153 336   0 

Output : 2085