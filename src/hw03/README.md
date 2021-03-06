# HW03_hill finding

[![hackmd-github-sync-badge](https://hackmd.io/CkReuzGVRXGJPjR5W3vDfw/badge)](https://hackmd.io/CkReuzGVRXGJPjR5W3vDfw)


###### tags: `演算法` `Java`

## 題目
一個長度為N的陣列，從h處切一刀下去，並左右對調，測資給你的就是這個切過的陣列，請你反推h是多少。

條件:
* -1 < h < N-1
* 不會出現全部值都相同的陣列，ex: 111111111
* 會出現重複的值

## 解題想法
### 三明治法
> HW03_4108056005_1.java

與hw02類似，從陣列左右端向內夾擊，正常情況下，左邊會遞增右邊會遞減，如果有例外就代表找到hill了

時間複雜度為: O(N/2)

### 二元搜尋樹
> HW03_4108056005_2.java
  
也類似hw02的二元搜尋，不過條件不同，我們設定三個變數start、mid、end。  
* 如果mid大於start，代表hill一定在mid~end之間，因此將 start = mid。
* 如果mid小於start，代表hill一定在start~mid之間，因此將 end = mid。
* 最後，start和mid所夾的點就是hill了。

很明顯的，這個複雜度為O(logN)，但可能助教測資不大，跟no.1比沒快多少。

還有一種情況，像是: 3333333123  
用二元搜尋會不清楚到底hill是在前段還是後段，所以如果mid等於start時，就使用no.1的方法。

### 多執行序
> HW03_4108056005_3.java

no.2只排在第18名，有點不爽，該來用多執行序了ㄎㄎ  
我想說將陣列切八段，每一段用二元搜尋hill，但考慮到可能會剛好切在hill上，因此我打算前後重疊。

但因為題目的關係，這次多執行序的表現並不太好。

### kashiwa
> HW03_4108056005_5.java

明明和我no.2一樣概念，但不知道為什麼超快，差了大概40名。