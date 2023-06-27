
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNAppCheckerSpec.h"

@interface AppChecker : NSObject <NativeAppCheckerSpec>
#else
#import <React/RCTBridgeModule.h>

@interface AppChecker : NSObject <RCTBridgeModule>
#endif

@end
