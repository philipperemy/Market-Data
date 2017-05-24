Realtime Market Data Feed from French CAC40
===========

Module to retrieve realtime stock quotes of Paris stock exchange.

- Download MySQL server: https://dev.mysql.com/downloads/mysql/
- Install it!
- Change the default password: https://support.rackspace.com/how-to/mysql-resetting-a-lost-mysql-root-password/
- Execute the queries inside the `queries.sql` file.
- Change the password in the file `src/persistence/DatabaseAccess.java`. The field is `PASSWORD`.
- Run the `src/src/Main.java` file to start! In my case I use [IntelliJ IDEA](https://www.jetbrains.com/idea/) to run it.

*Important Notes:*

- By default, the script pulls data from 09:00 to 17:35, every **30sec**.

Output example:

```
Wed May 24 16:54:57 JST 2017 [INFO] - start time = Wed May 24 09:00:00 JST 2017
Wed May 24 16:54:57 JST 2017 [INFO] - end time = Wed May 24 17:38:00 JST 2017
Wed May 24 16:54:57 JST 2017 [INFO] - Initializing database...
Wed May 24 16:54:58 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPVIV
Wed May 24 16:54:58 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPCA
Wed May 24 16:54:58 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPRI
Wed May 24 16:54:58 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPBN
Wed May 24 16:55:02 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPAC
Wed May 24 16:55:02 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPEDF
Wed May 24 16:55:03 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPMC
Wed May 24 16:55:03 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPPUB
Wed May 24 16:55:04 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPVIE
Wed May 24 16:55:05 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPEN
Wed May 24 16:55:05 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPDG
Wed May 24 16:55:06 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPORA
Wed May 24 16:55:07 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPSTM
Wed May 24 16:55:07 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPSAF
Wed May 24 16:55:08 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPALU
Wed May 24 16:55:08 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPLR
Wed May 24 16:55:09 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPAI
Wed May 24 16:55:09 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPGSZ
Wed May 24 16:55:10 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPTEC
Wed May 24 16:55:11 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPALO
Wed May 24 16:55:11 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPSAN
Wed May 24 16:55:12 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPCAP
Wed May 24 16:55:13 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPSGO
Wed May 24 16:55:13 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPRNO
Wed May 24 16:55:13 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPOR
Wed May 24 16:55:15 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPLG
Wed May 24 16:55:15 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPKER
Wed May 24 16:55:15 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPCS
Wed May 24 16:55:16 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPEAD
Wed May 24 16:55:17 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPML
Wed May 24 16:55:18 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPUG
Wed May 24 16:55:19 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPVK
Wed May 24 16:55:19 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPFP
Wed May 24 16:55:19 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPGLE
Wed May 24 16:55:20 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPBNP
Wed May 24 16:55:21 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPEI
Wed May 24 16:55:21 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPSU
Wed May 24 16:55:21 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPACA
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( BN, 66.38 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( RI, 120.25 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( VIV, 19.395 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( CA, 22.965 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( AC, 42.195 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( EDF, 9.486 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( MC, 227.30 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( PUB, 65.87 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( VIE, 19.750 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( EN, 37.910 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( DG, 77.08 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( ORA, 15.625 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( STM, 14.530 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( SAF, 76.11 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( ALU, 3.50 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( LR, 61.17 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( AI, 111.05 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( GSZ, 13.480 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( TEC, 67.40 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( ALO, 30.720 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( SAN, 87.84 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( CAP, 92.25 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( SGO, 50.020 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( RNO, 85.74 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( OR, 188.15 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( LG, 59.96 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( KER, 292.00 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( CS, 24.080 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( EAD,  )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( ML, 114.30 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( UG, 18.320 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( VK, 6.006 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( FP, 48.270 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( GLE, 50.23 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( BNP, 66.52 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( EI, 119.10 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( SU, 69.15 )
Wed May 24 16:55:24 JST 2017 [INFO] - Inserting ( ACA, 14.705 )
Wed May 24 16:55:54 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPBN
Wed May 24 16:55:54 JST 2017 [INFO] - Performing Http GET Request : http://www.boursorama.com/cours.phtml?symbole=1rPRI
[...]
```
