Case 1 - Web Automation
Java + selenium ile yazılmıştır.

insiderone.com web sitesinden https:/insiderone.com/careers/quality-assurance/ gidip See all QA
jobs butonuna tıklar. Gelen ekranda Location olarak "Istanbul" ve department olarak "department - Quality
Assurance" seçilir. İlan listesi check edilir. View role butonuna tıklanır. Lever sayfasının açıldığı kontrol edilir.
Proje hem chrome hem firefox ile çalıştırabilir. Configuration.properties dosyasında "browser=firefox" şeklinde parametrik olarak verilmiştir. chrome için browser=chrome , firefox için ise browser=firefox olarak değiştirilmelidir.

Case 2 - Load Test:

Jmeter ile n11 arama ve listeleme yük testini komutla koşulabilmesi için .jmx dosyasını bulunduğu klasörde raporun oluşması için bir rapor dosyası oluşturmanız ve aşağıdaki komutu bilgisayarınızda .jmx  dosyasının bulunduğu klaösöre gidip komut istemcisini çalıştırmanız gerekmektedir.
->jmeter -n -t Test Planı Adı.jmx -l Oluşturduğunuz Klasörün Yolu\sonuc.csv -e -o Oluşturduğunuz Klasörün Yolu
Bu komut test planınızı bulup yük testinizi koşar ve sonrasında oluşturduğunuz rapor klasöründe rapor oluşturur.


Case 3 - Api Automation:

Postman kullanılarak yazılmıştır.

Bu case içinde bulunan collection https://petstore.swagger.io/ swaggerda bulunan requestleri otomatize etmek için oluşturulmuştur.newman ile çalıştırmak için cihazınızda node.js ve newman yüklü olmalıdır. 
Belli periyotlartla otomatik koşum için jenkins ile entegre edilebilir.

Case 1: Random bir id ile yeni bir pet oluşturur.
Case 2: Oluşturulan yeni pet'in photoUrl ini update eder.
Case 3: Oluşturulan yeni pet'i listeler.
Case 4: Var olmayan bir pet id ile listeleme dener(negatif case)
Case 5: photoUrl i kaybetmeden pet name i günceller.
Case 6: Oluşturulan yeni pet'i siler.
Case 7: Silinen pet'i tekrar silmeye çalışır.(Negatif case).
Case 8: available status deki Petleri listeler.
Case 9: pending status deki Petleri listeler.
Case 10: sold status deki Petleri listeler

Sorularınız için iletişime geçmekten çekinmeyin.
