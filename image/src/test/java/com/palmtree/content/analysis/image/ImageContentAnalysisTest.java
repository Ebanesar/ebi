package com.palmtree.content.analysis.image;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kaarthikraaj on 5/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)

@WebAppConfiguration
public class ImageContentAnalysisTest {
    ImageContentAnalyser imageContentAnalyser = new ImageContentAnalyser();

    //TestCase for Validating the image 

    @Test
  /*  public void testImageValidityWithCoolingGlass(){
        boolean valid = imageContentAnalyser.isValidImage("http://images.huffingtonpost.com/\n" +
                "2014-05-03-bwbw3.jpg");
        Assert.assertFalse(valid);
    }
   public void testImageValidityWithHeadWear()
    {
        boolean valid = imageContentAnalyser.isValidImage("http://media.gettyimages.com/photos/man-\n" +
                "wearing-baseball-cap-portrait-\n" +
                "picture-id159749279?s=612x612");
        Assert.assertFalse(valid);
    }
    public void testImageValidityWithFaceMask(){
        boolean valid = imageContentAnalyser.isValidImage("https://zahnsply.com/image/cache/data/Indian/face-mask-634-600x600.jpg");
        Assert.assertFalse(valid);
    }
    public void testImageValidityWithFaceTattoos(){
        boolean valid = imageContentAnalyser.isValidImage("https://i.redd.it/v53wsi5b5xtx.jpg");
        Assert.assertFalse(valid);
    }
    public void testImageValidityWithActor(){
        boolean valid = imageContentAnalyser.isValidImage("http://media2.intoday.in/indiatoday/images/stories//2015December/hrithik-roshan-650-x-350_121815031425.jpg");
        Assert.assertFalse(valid);
    }
    public void testImageValidityWithActress(){
        boolean valid = imageContentAnalyser.isValidImage("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Deepika_Padukone_at_Piku_event.jpg/170px-Deepika_Padukone_at_Piku_event.jpg");
        Assert.assertFalse(valid);
    }
    public void testImageValidityWithAnimal(){
        boolean valid = imageContentAnalyser.isValidImage("http://cdn.playbuzz.com/cdn/143e9600-862d-449b-957c-e90c54854554/f0ff0eb9-7e80-4c09-8723-ff1b625eb1d7.jpg");
        Assert.assertFalse(valid);
    }
    public void testImageValidityWithClearFace(){
        boolean valid = imageContentAnalyser.isValidImage("https://na-production.s3.amazonaws.com/images/ben-barrett_person_image.original.jpg");
        Assert.assertTrue(valid);
    }  */
    // Testcase for Unsafe image
  /*  public void testImageUnsafeWithWeapon()
    {
        boolean safe = imageContentAnalyser.isImageSafe("https://static1.squarespace.com/static/54dd2136e4b0886d9bf86b76/551ad3fde4b06bbc6f59dda4/551ad3fee4b06bbc6f59df30/1370644821203/1000w/10214704-22867150-thumbnail.jpg");
        Assert.assertFalse(safe);
    }     */
 /*   public void testImageUnsafeWithAdult()
    {
        boolean safe = imageContentAnalyser.isImageSafe("https://www.dailydot.com/wp-content/uploads/6c855233625ee8c7985a841c4bd068dd5e1.jpg/91/");
        Assert.assertFalse(safe);
    }     */

   /* public void testImageUnsafeWithBlood()
    {
        boolean safe = imageContentAnalyser.isImageSafe("");
        Assert.assertFalse(safe);
    }     */
   /* public void testImageUnsafeWithSmooking()
    {
        boolean safe = imageContentAnalyser.isImageSafe("http://cdn.images.express.co.uk/img/dynamic/11/590x/secondary/Person-smoking-931619.jpg");
        Assert.assertFalse(safe);
    }      */
   /* public void testImageUnsafeWithAlcoholic()
    {
        boolean safe = imageContentAnalyser.isImageSafe("http://www.healthywomen.org/sites/default/files/man-drinking.jpg");
        Assert.assertFalse(safe);
    }     */
   /* public void testImageWithDaemon()
    {
        boolean safe= imageContentAnalyser.isImageSafe("http://vignette1.wikia.nocookie.net/warhammer40k/images/2/23/Bloodletter.jpg/revision/latest?cb=20111021182614");
        Assert.assertFalse(safe);
    }   */
 /*  public void testImageWithStabbing()
    {
        boolean safe = imageContentAnalyser.isImageSafe("http://assets.nydailynews.com/polopoly_fs/1.1706765.1393626005!/img/httpImage/image.jpg_gen/derivatives/article_750/177867420.jpg");
        Assert.assertFalse(safe);
    }    */
  /*  public void testImageWithShooting()
    {

        boolean safe = imageContentAnalyser.isImageSafe("https://previews.123rf.com/images/ysbrandcosijn/ysbrandcosijn1406/ysbrandcosijn140600071/28895439-Action-hero-muscled-man-shooting-with-gun-Wearing-black-t-shirt--Stock-Photo.jpg");
        Assert.assertFalse(safe);
    }   */
    // Testcase for Logo Detection
  /* public void testImageWithMultipleLogo()
    {
       List<String> logo = imageContentAnalyser.detectLogos("https://qph.ec.quoracdn.net/main-qimg-a23d919a8f7d7cd655abd66eff61fa13-c");
       List<String> logo_detect = Arrays.asList("Google", "Lenovo");
       Assert.assertEquals(logo_detect,logo);
    }    */
   /* public void testImageWithAdidasLogo()
    {
        List<String> logo = imageContentAnalyser.detectLogos("https://n1.sdlcdn.com/imgs/a/8/u/Adidas-White-Running-Sports-Shoes-SDL070564296-3-053d6.jpg");
        List<String> logo_detect = Arrays.asList("Adidas");
        Assert.assertEquals(logo_detect,logo);
    }  */
  /* public void testImageWithRebookLogo()
    {
        List<String> logo = imageContentAnalyser.detectLogos("https://3.imimg.com/data3/WD/AI/MY-2184756/reebok-english-willow-cricket-bats-250x250.jpg");
        List<String> logo_detect = Arrays.asList("Reebok");
        Assert.assertEquals(logo_detect,logo);
    }   */
   /*public void testImageWithPumaLogo()
    {
        List<String> logo = imageContentAnalyser.detectLogos("http://www.hellohelp.in/wp-content/uploads/2016/03/Best-Puma-Shoes-For-Men.jpg");
        List<String> logo_detect = Arrays.asList("Puma");
        Assert.assertEquals(logo_detect,logo);
    }      */
   /* public void testImageWithHpLogo()
    {
        List<String> logo = imageContentAnalyser.detectLogos("https://images-na.ssl-images-amazon.com/images/I/41oMAbfbj3L.jpg");
        List<String> logo_detect = Arrays.asList("HP Name");
        Assert.assertEquals(logo_detect,logo);
    } */
    /*   public void testImageWithAudiLogo()
       {
           List<String> logo = imageContentAnalyser.detectLogos("http://www.carlogos.org/logo/Audi-logo-1999-1920x1080.png");
           List<String> detect = Arrays.asList("Audi");
           Assert.assertEquals(detect,logo);
       }  */

    //Landmark Testcase

 /*   public void testLandmarkDetection1()
    {
        List<String> landmark = imageContentAnalyser.detectLandmarks("http://www.nationsonline.org/gallery/Monuments/Taj_Mahal.jpg");
        List<String> landmark_detect = Arrays.asList("Taj Mahal");
        Assert.assertEquals(landmark_detect,landmark);
    }              */
  /*  public void testImageWithTajMahalLandmark()
    {
        List<String> landmark = imageContentAnalyser.detectLandmarks("http://www.nationsonline.org/gallery/Monuments/Taj_Mahal.jpg");
        List<String> landmark_detect = Arrays.asList("Taj Mahal");
       Assert.assertEquals(landmark_detect,landmark);
    } */
   /* public void testImageWithMoaiLandmark()
    {
        List<String> landmark = imageContentAnalyser.detectLandmarks("http://images.china.cn/attachement/jpg/site1007/20131028/002564baec4813d85ad70d.jpg");
        List<String> landmark_detect = Arrays.asList("Moai");
        Assert.assertEquals(landmark_detect,landmark);
    }   */
    public void testImageWithPisaLandmark()
    {
        List<String> landmark = imageContentAnalyser.detectLandmarks("http://billiger-leihwagen.autoeurope.de/images/pisa2.jpg");
       List<String> landmark_detect = Arrays.asList("Piazza dei Miracoli");
        Assert.assertEquals(landmark_detect,landmark);
    }
   /* public void testImageWithRedFortLandmark()
    {
        List<String> landmark = imageContentAnalyser.detectLandmarks("http://s3.india.com/travel/wp-content/uploads/red-fort-preset3.jpg");
        List<String> landmark_detect = Arrays.asList("Red Fort" , "The Red Fort" , "The Red Fort");
        Assert.assertEquals(landmark_detect,landmark);
    } */
   /* public void testImageWithLibertyStatueLandmark()
    {
        List<String> landmark = imageContentAnalyser.detectLandmarks("http://www.countrydetail.com/wp-content/uploads/2016/03/top-ten-places-in-america-to-visit-e1458479085994.jpg");
        List<String> landmark_detect = Arrays.asList("Statue of Liberty");
        Assert.assertEquals(landmark_detect,landmark);
         }     */
  /*  public void testImageWithMultipleLandmark()
    {
        List<String> landmark = imageContentAnalyser.detectLandmarks("http://1.bp.blogspot.com/-n6KfRZ4xp7M/TcaF_G0SkaI/AAAAAAAAAMs/o-SVolIyH3w/s1600/thenew7wonders.jpg");
        List<String> landmark_detect = Arrays.asList("Christ The Redeemer" , "Petra" ,
                "Taj Mahal" , "Colosseum" , "Machu Picchu");
        Assert.assertEquals(landmark_detect,landmark);
    }     */
}
