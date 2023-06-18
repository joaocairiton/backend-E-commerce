import { TestBed } from '@angular/core/testing';

import { AuthNormalGuard } from './auth-normal.guard';

describe('AuthNormalGuard', () => {
  let guard: AuthNormalGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthNormalGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
