import UIKit
import Common
import AVFoundation

var audioPlayer : AVAudioPlayer?

class IosPlaySound: PlaySound {
    func play() {
        audioPlay()
    }
}

@main
class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?

    
    override init() {
        _ = KoinInjector(playSound: IosPlaySound()).koinApp
    
    }
    
    func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
    ) -> Bool {
        window = UIWindow(frame: UIScreen.main.bounds)
        if let window = window {
            window.rootViewController = MainKt.MainViewController()
            window.makeKeyAndVisible()
        }
        return true
    }
}

func audioPlay() {
    
    let resourcePath = Bundle.main.url(forResource: "cat_sound", withExtension: "mp3")
    
    do{
        //initializing audio player with the resource path
        audioPlayer = try AVAudioPlayer(contentsOf: resourcePath!)
        
        audioPlayer?.play()
    
        
    }
    catch{
      //error handling
        print(error.localizedDescription)
    }
}


